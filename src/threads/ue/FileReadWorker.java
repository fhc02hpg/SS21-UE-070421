package threads.ue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {

  private String path;
  public ArrayList<String> lines = new ArrayList<>();

  public FileReadWorker(String name, String path) {
    super(name);
    this.path = path;
  }

  @Override
  public void run() {
    work();
  }

  @Override
  protected void work() {
    printStarted();
    try(BufferedReader br = new BufferedReader(new FileReader(path))) {
      String l = "";
      while((l = br.readLine())!=null) {
        lines.add(l);
        if(!shouldRun) {
          break;
        }
        Thread.sleep(5);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    printStopped();
  }
}
