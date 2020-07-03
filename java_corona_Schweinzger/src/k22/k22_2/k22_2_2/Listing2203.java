/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_2.k22_2_2;

/**
 *
 * @author Christoph-PC
 */
public class Listing2203 extends Thread {
    int cnt = 0;

    @Override
    public void run() {
        while(true) {
            if(isInterrupted()) {
                break;
            }
            cnt++;
            printLine(cnt);
        }
    }
    
    private void printLine(int cnt) {
        System.out.println(cnt + ": ");
        for(int i = 0; i < 30; ++i) {
            if(i == cnt % 30) {
                System.out.println(".");
            } else {
                System.out.println("*");
            }
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch(Exception ex) {
            interrupt();
        }
    }
    
    public static void main(String[] args) {
        Listing2203 thread = new Listing2203();
        thread.start();
        
        try {
            Thread.sleep(5000);
        } catch(Exception ex) {
            
        }
        thread.interrupt();
    } 
}
