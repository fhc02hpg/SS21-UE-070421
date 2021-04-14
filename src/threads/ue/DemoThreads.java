package threads.ue;

public class DemoThreads {

  public static void main(String[] args) {

    System.out.println("main started");
    try {
      TimePrintWorker twp = new TimePrintWorker("TPW");
      Thread ttime = new Thread(twp);
      ttime.start();

      Thread tread = new Thread(new FileReadWorker("FRW","data/testdata-einwohner.csv"));
      tread.start();
      tread.join(); //wait till thread ends

      twp.stopWorker();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("main ended");
  }

}
