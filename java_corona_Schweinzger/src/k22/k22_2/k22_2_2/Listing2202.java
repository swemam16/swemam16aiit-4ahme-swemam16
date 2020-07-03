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
public class Listing2202 {
    public static void main(String[] args) {
        MyThread2202 thread = new MyThread2202();
        thread.start();
        
        try {
            Thread.sleep(5000);
        } catch(Exception ex) {
            System.out.println("Fehler bei Sleep");
        }
        thread.stop();
        // Deprecated => Nicht verwenden
        // Besser: interrupt()
    }
}
