/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_3.k22_3_2;

/**
 *
 * @author Christoph-PC
 */
public class ThreadedPrimeNumberTools extends PrimeNumberTools implements Runnable {

    private int arg;
    private int func;
    
    public void printPrimeFactors(int num) {
        execAsynchron(1, num);
    }
    
    public void printPrime(int cnt) {
        execAsynchron(1, cnt);
    }
    
    @Override
    public void run() {
        if(func == 1) {
            super.printPrimeFactors(arg);
        } else if(func == 2) {
            int result = super.getPrime(arg);
            System.out.println("prime number " + arg + " is: " + result);
        }
    }

    private void execAsynchron(int func, int arg) {
        Thread thread = new Thread(this);
        this.func = func;
        this.arg = arg;
        thread.start();
    }
}
