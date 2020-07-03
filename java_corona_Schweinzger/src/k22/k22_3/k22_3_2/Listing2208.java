/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_3.k22_3_2;


import java.util.Scanner;

/**
 *
 * @author Christoph-PC
 */
public class Listing2208 {
    public static void main(String[] args) {
        ThreadedPrimeNumberTools pt;
        Scanner sc = new Scanner(System.in);
        
        int num;
        // Formatierungsprobleme bei der Ausgabe
        try {
            while(true) {
                System.out.print("Zahl eingeben: ");
                num = sc.nextInt();
                if(num == -1) {
                    break;
                }
                pt = new ThreadedPrimeNumberTools();
                pt.printPrime(num);
            }
        } catch(Exception ex) {
            
        }
    }
    
}
