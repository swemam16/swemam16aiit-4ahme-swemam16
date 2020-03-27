package k22.k22_3.k22_3_2;

public class ThreadedPrimeNumberTools extends PrimeNumberTools implements Runnable {
  private int arg;
  private int func;

  @Override
  public void printPrimeFactors(int num) {
    execAsynchron(1,num);
  }

  public void printPrime(int cnt) {
    execAsynchron(2,cnt);
  }

  @Override
  public void run() {
    if (func == 1) {
      super.printPrimeFactors(arg);
    } else if (func == 2) {
      int result = super.getPrime(arg);
      System.out.println("prime number #"+arg+" is: "+result);
    }
  }

  private void execAsynchron(int func, int arg) {
    Thread t = new Thread(this);
    this.func = func;
    this.arg  = arg;
    t.start();
  }
}