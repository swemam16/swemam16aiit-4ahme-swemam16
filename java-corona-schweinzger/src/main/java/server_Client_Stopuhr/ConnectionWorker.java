package server_Client_Stopuhr;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.swing.SwingWorker;

public class ConnectionWorker extends SwingWorker<String, Integer>{
    
    private Socket socket;
    

    public ConnectionWorker(int port, String hostName) {
        
    }

    @Override
    protected String doInBackground() throws Exception{
        System.out.println("Background" + Thread.currentThread().getId());
        Thread.sleep(1000);
        publish(1);
        Thread.sleep(1000);  
        publish(2);
        Thread.sleep(1000);
         
        return "OK";

    }
}