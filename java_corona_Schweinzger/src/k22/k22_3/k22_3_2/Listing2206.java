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
public class Listing2206 {
    public static void main(String[] args) {
        PrimeNumberTools pt = new PrimeNumberTools();
        final Scanner sc = new Scanner(System.in);
    
        int num;
        
        try {
            while(true) {
                System.out.println("Bitte eine Zahl eingeben: ");
                num = sc.nextInt();
                if(num == -1) {
                    break;
                }
                pt.printPrimeFactors(num);
            }
        } catch(Exception ex) {
            
        }
    }
    
}
