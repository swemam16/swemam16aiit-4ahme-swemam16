package k22.k22_3.k22_3_1;

class A2204 {
  int irgendwas;
}

class B2204
extends A2204 implements Runnable {
   @Override
   public void run() {
      int i = 0;
      while (true) {
         if (Thread.interrupted()) {
            break;
         }
         System.out.println(i);
         i++;
      }
   }
}

public class Listing2204 {
    public static void main(String[] args) {
        B2204 b = new B2204();
        Thread t = new Thread(b);
        t.start();
        try {
           Thread.sleep(1000);
        } catch (InterruptedException ex){}
        t.interrupt();
    }
}
