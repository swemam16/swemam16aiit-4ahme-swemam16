package server_Client_Stopuhr;

public class Response {
    private boolean master;
    private long count;
    private boolean running;
    private long time;
    private String connected;

    public Response(boolean master, long count, boolean running, long time, String connected) {
        this.master = master;
        this.count = count;
        this.running = running;
        this.time = time;
        this.connected = connected;
    }
    
    
}
