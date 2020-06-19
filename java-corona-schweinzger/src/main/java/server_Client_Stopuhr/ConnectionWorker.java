package server_Client_Stopuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import javax.swing.SwingWorker;

public class ConnectionWorker extends SwingWorker<String, Response>{
    
    private Socket socket;
    

    public ConnectionWorker(int port, String hostName) {
        
    }

    @Override
    protected String doInBackground() throws Exception{
        
        final Gson g = new Gson();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
        
        while(true){
            try{
                final Request req = new Request();
                final String reqString = g.toJson(req);
                writer.write(reqString);
                writer.flush();

                final String respString = reader.readLine();
                final Response resp = g.fromJson(respString, Response.class);
                publish(resp);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    
}