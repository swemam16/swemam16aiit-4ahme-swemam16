package k22.k22_2.k22_2_3;

public class Listing2203 extends Thread {
  int cnt = 0;

  public void run() {
    while (true) {
      if (isInterrupted()) {
        break;
      }
      cnt++;
      printLine(cnt);
    }
  }

    private void printLine(int cnt) {
      System.out.print(cnt + ": ");
      for (int i = 0; i < 30; ++i) {
        System.out.print(i == cnt%30 ? "* " : ". ");
      }
      System.out.println();
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
        interrupt();
      }
    }

    public static void main(String[] args) {
      Listing2203 th = new Listing2203();
      {
        th.start();
        try {
          Thread.sleep(2000);
        }catch (InterruptedException ex) {}
        th.interrupt();
      }
    }
}