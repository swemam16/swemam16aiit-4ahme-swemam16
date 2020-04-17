package Server_Client_Stopuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
        BufferedReader reader = new BufferedReader(new InputStream);
        String line;
        try {
            line = reader.readLine();
        } catch (IOException ex) {
            throw new IllegalArgumentException();
        }
        Gson gson = new Gson();
        gson.toJson(line);
    }
    
}