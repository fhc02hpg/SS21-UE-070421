package threads.ue;

import java.time.LocalDateTime;

public class TimePrintWorker extends Worker implements Runnable {

  public TimePrintWorker(String name) {
    super(name);
  }

  @Override
  public void run() {
    work();
  }

  @Override
  protected void work() {
    printStarted();
    while(shouldRun) {
      System.out.println(LocalDateTime.now());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    printStopped();
  }
}
