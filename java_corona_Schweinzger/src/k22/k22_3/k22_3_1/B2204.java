/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_3.k22_3_1;

/**
 *
 * @author Christoph-PC
 */
public class B2204 extends A2204 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while(true) {
            if(Thread.interrupted()) {
                break;
            }
            System.out.println(i);
            i++;
        }
    }
    
}
