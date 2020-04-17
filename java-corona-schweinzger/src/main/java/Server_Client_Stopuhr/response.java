package Server_Client_Stopuhr;

public class response {
    private boolean master;
    private long count;
    private boolean running;
    private long time;

    public response(boolean master, long count, boolean running, long time) {
        this.master = master;
        this.count = count;
        this.running = running;
        this.time = time;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public long isCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public long isTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    
}
