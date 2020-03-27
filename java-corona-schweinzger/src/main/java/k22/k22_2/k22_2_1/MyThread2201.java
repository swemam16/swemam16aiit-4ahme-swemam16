package k22.k22_2.k22_2_1;

class MyThread2201 extends Thread {
  @Override
  public void run() {
    int i = 0;
    while (true) {
      System.out.println(i);
      i++;
    }
  }
}