package server_Client_Stopuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
   
    
    public void start (int port) throws IOException {
        serverSocket = new ServerSocket(port);
        startMillis = System.currentTimeMillis();
        
        while(true){
            final Socket clientSocket = serverSocket.accept();
            for(ConnectionHandler h: handlers){
                    if(h.isClosed()){
                        handlers.remove(h);
                    }
            }
            if(handlers.size() == 3){
                clientSocket.close();
                continue;
            }
                final ConnectionHandler handler = new ConnectionHandler(clientSocket);    
                new Thread(handler).start();
                handlers.add(handler);
        }   
    }
    
    public boolean isTimerRunning() {
        return startMillis > 0;
    }
    
    public long getTimerMillis() {
        if(startMillis > 0){
            return  System.currentTimeMillis() - startMillis + timeOffset;
        } else {
            return timeOffset;
        }
    }
    
    public static void main(String[] args) throws IOException{
        new Server().start(8080);
    }


    class ConnectionHandler implements Runnable {

        private final Socket socket;
        private boolean master;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public boolean isClosed() {
            return socket.isClosed();    
        }

        public boolean isMaster() {
            return master;
        }

        @Override
        public void run() {
            int cnt = 0;

            while(true){
                try {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final String requestLine = reader.readLine();
                    cnt++;
                    final Gson gson = new Gson();
                    gson.toJson(requestLine);
                    Request req = gson.fromJson(requestLine, Request.class);

                    if(req.isMaster()){
                        for(ConnectionHandler c : handlers){
                            this.master = true;
                            if(c != this && c.isMaster() == true){
                                this.master = false;
                            }
                        }
                    }    
                    
                    if(req.isMaster()){
                        if(req.isStart()){
                            startMillis = System.currentTimeMillis();
                        }
                        if(req.isStop()){
                            startMillis = 0;
                        } else {
                            timeOffset = getTimerMillis();
                        }
                        if(req.isClear()){
                            timeOffset = 0;
                            if(isTimerRunning()){
                                startMillis = System.currentTimeMillis();
                            } else {
                                startMillis = 0;
                            }
                        }
                        if(req.isEnd()){
                            serverSocket.close();
                            socket.close();
                            handlers.remove(this);
                            return;
                        }
                    }

                    Response resp = new Response(master, cnt, isTimerRunning(), getTimerMillis());
                    String responseLine = gson.toJson(resp);
                    final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                    writer.write(responseLine);
                    writer.flush();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }   
    }
}