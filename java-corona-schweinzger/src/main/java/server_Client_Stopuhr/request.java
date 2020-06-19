package server_Client_Stopuhr;

public class Request {
    
    private boolean master;
    private boolean start;
    private boolean stop;
    private boolean clear;
    private boolean end;

    public Request(boolean b, boolean start, boolean stop, boolean clear, boolean end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public boolean isMaster() {
        return master;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isStop() {
        return stop;
    }

    public boolean isClear() {
        return clear;
    }

    public boolean isEnd() {
        return end;
    }
    
    
    
    
    
}
