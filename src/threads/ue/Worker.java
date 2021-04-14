package threads.ue;

public abstract class Worker {

  protected String name;
  protected boolean shouldRun;

  public Worker(String name) {
    this.name = name;
    shouldRun = true;
  }

  protected abstract void work();

  protected void printStarted() {
    System.out.println(name + " was started");
  }

  protected void printStopped() {
    System.out.println(name + " was stopped");
  }

  public void stopWorker() {
    shouldRun = false;
  }

}
