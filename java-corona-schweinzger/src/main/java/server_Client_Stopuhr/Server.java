/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_Client_Stopuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private ServerSocket serversocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;

    public void start(int port) throws IOException {        
        serversocket = new ServerSocket(port);
        
        while(true) {
            final Socket socket = serversocket.accept();
            synchronized(handlers) {
                for(int i = 0; i < handlers.size(); i++) {
                    ConnectionHandler h = handlers.get(i);
                    if(h.isClosed()) {
                        handlers.remove(h);
                    }
                }   
                
                if(handlers.size() == 3) {
                    socket.close();
                    continue;
                }
            }

            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            synchronized(handler) {
                handlers.add(handler);
            }
        }
    }
    
    public boolean isTimerRunning() {
        synchronized(handlers) {
            return startMillis > 0;    
        }
    }
    
    public long getTimerMillis() {
        synchronized(handlers) {
            if(startMillis > 0) {
                return System.currentTimeMillis() - startMillis + timeOffset;
            } else {
                return timeOffset;
            } 
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Server().start(8080);
    }
      
            
    private class ConnectionHandler implements Runnable {
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
            int count = 0;
            while(true) {
                try {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                    final String req = reader.readLine();
                    if(req == null) {
                        socket.close();
                        return;
                    }
                    count++;
                    System.out.println(req);
                    final Gson gson = new Gson();
                    final Request r = gson.fromJson(req, Request.class);

                    if(r.isMaster()) {
                        boolean setMasterTrue = true;
                        synchronized(handlers) {
                            for(int i = 0; i < handlers.size(); i++) {
                                ConnectionHandler h = handlers.get(i);
                                if(h != this && h.isMaster()) {
                                    setMasterTrue = false;
                                    break;
                                }
                            }
                        }
                        master = setMasterTrue;
                    }
                    synchronized(handlers) {
                        if(r.isMaster()) {
                            if(r.isStart()) {
                                startMillis = System.currentTimeMillis();
                            }

                            if(r.isStop()) {
                                startMillis = 0;
                            } else {
                                if(isTimerRunning()) {
                                    timeOffset = System.currentTimeMillis() - startMillis + timeOffset;
                                }  
                            }

                            if(r.isClear()) {
                                timeOffset = 0;
                                if(isTimerRunning()) {
                                    startMillis = System.currentTimeMillis();
                                } else {
                                    startMillis = 0;
                                } 
                            }

                            if(r.isEnd()) {
                                serversocket.close();
                                socket.close();
                                synchronized(handlers) {
                                    handlers.remove(this);
                                }
                                return;
                            }        
                        }
                    }


                    //Response
                    final Response resp = new Response(master, count, isTimerRunning(), getTimerMillis(), socket.toString());
                    final String respString = gson.toJson(resp);
                    writer.write(respString);
                    writer.flush();
                    System.out.println(respString);
                } catch(Exception ex) {
                    ex.printStackTrace();
                    return;
                } 
            }
        }
    }
}
