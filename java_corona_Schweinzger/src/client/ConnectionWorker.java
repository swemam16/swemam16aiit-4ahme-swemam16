package client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;
import javax.swing.SwingWorker;
import server.Request;
import server.Response;


public class ConnectionWorker extends SwingWorker<String, Response> {
  
    @Override
    protected void process(List<Response> list) {
    }

    @Override
    protected void done() {
        super.done();
    }

    @Override
    protected String doInBackground() throws Exception {
        return "Ok";
    }
}
