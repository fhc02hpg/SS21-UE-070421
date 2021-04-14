package file.io.ue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EinwohnerDemo {

  public static void main(String[] args) {

    EinwohnerManager em = new EinwohnerManager();

    try {
      ArrayList<Einwohner> el = em.load();
      for(Einwohner e : el) {
        System.out.println(e);
      }
      Map<String, List<String>> groupBundesland
          = em.getAllNamenByBundesland(el);
      for (Map.Entry<String,List<String>> e : groupBundesland.entrySet()) {
        System.out.println(e.getKey() +" -> "+ e.getValue());
      }

      Map<String, Integer> avgAlter = em.getAvgAlterByBundesland(el);
      for (Map.Entry<String,Integer> e : avgAlter.entrySet()) {
        System.out.println(e.getKey() +" -> "+ e.getValue());
      }

    } catch (DataFileException e) {
      e.printStackTrace();
    }


  }

}
