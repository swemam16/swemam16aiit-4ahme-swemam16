package k22.k22_2.k22_2_2;

public class Listing2202 {
    public static void main(String[] args) {
        MyThread2202 t = new MyThread2202();
        t.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ex) {}
        t.stop(); //Funktion ist deprecated deshalb nicht mehr zu verwenden
    }
}

