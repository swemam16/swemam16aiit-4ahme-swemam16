package server_Client_Stopuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        
        timeOffset = 0;
        startMillis = System.currentTimeMillis();
        
        while(true){
            final Socket clientSocket = serverSocket.accept();
            final ConnectionHandler handler = new ConnectionHandler(clientSocket);    
            new Thread(handler).start();
            handlers.add(handler);
        }   
    }
    
    public boolean isTimerRunning() {
        return         
    }
    
    public long getTimerMillis() {
        return  System.currentTimeMillis() - startMillis;
    }
    
    public static void main(String[] args){
        new Server();
    }



    class ConnectionHandler implements Runnable {

        private Socket socket;
        private boolean master;

        public ConnectionHandler(Socket socket) {

        }

        public boolean isClosed() {
            return         
        }

        public boolean isMaster() {
            return 
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                line = reader.readLine();

                Gson gson = new Gson();
                gson.toJson(line);
                Request req = gson.fromJson(line, Request.class);
                
                if(req.isMaster()){
                    for(ConnectionHandler c : handlers){
                        this.master = true;
                        if(c != this && c.isMaster() == true){
                            this.master = false;
                        }
                    }
                }        
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
                }
                if(req.isEnd()){
                    socket.close();
                    handlers.remove(this);
                }
                
                
 
            
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }   
    }
}