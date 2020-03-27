package k22.k22_3.k22_3_2;

import java.io.*;

public class Listing2206 {
  public static void main(String[] args) {
    PrimeNumberTools pt = new PrimeNumberTools();
    BufferedReader   in = new BufferedReader(new InputStreamReader(new DataInputStream(System.in)));
    int num;

    try {
      while (true) {
        System.out.print("Bitte eine Zahl eingeben: ");
        System.out.flush();
        num = (new Integer(in.readLine()));
        if (num == -1) {
          break;
        }
        pt.printPrimeFactors(num);
      }
    } catch (IOException ex) {}
  }
}