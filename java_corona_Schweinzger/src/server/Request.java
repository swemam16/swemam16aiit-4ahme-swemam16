/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Christoph-PC
 */
public class Request {
    
    private boolean master;
    private Boolean start;
    private boolean stop;
    private boolean clear;
    private boolean end;
    
    public Request(boolean master, boolean start, boolean stop, boolean clear, boolean end) {
        this.master = master;
        this.start = start;
        this.stop = stop;
        this.clear = clear;
        this.end = end;
    }

    public boolean isMaster() {
        return master;
    }

    public boolean isStart() {
        return start != null && start;
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
