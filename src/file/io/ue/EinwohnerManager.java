package file.io.ue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EinwohnerManager {

  public ArrayList<Einwohner> load() throws DataFileException {

    ArrayList<Einwohner> list = new ArrayList<>();

    try(BufferedReader br = new BufferedReader(
        new FileReader("data/testdata-einwohner.csv"))) {

      String line = "";
      br.readLine(); //csv kopfzeile
      while((line = br.readLine()) != null) {
        String[] parts = line.split(";");
        //check for completeness of single line
        if(parts.length != 4) {
          throw new DataFileException("datensatz im csv ungültig: "+line);
        }
        Einwohner e = new Einwohner(
            Integer.parseInt(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3])
        );
        list.add(e);
      }
      list.sort(new GeburtsjahrDescNameAsc());
      return list;
    } catch (IOException e) {
      throw new DataFileException("fehler beim laden von csv datei",e);
    }

  }

  public Map<String, List<String>>
      getAllNamenByBundesland(ArrayList<Einwohner> list) {

    HashMap<String, List<String>> map = new HashMap<>();

    for(Einwohner e : list) {
      if(map.containsKey(e.getBundesland())) {
        map.get(e.getBundesland()).add(e.getName());
      } else {
        ArrayList<String> namesNew = new ArrayList<>();
        namesNew.add(e.getName());
        map.put(e.getBundesland(),namesNew);
      }
    }

    return map;

  }

  public Map<String,Integer> getAvgAlterByBundesland(ArrayList<Einwohner> list) {

    Map<String,Integer> mapCount = new HashMap<>();

    for(Einwohner e : list) {
      if(mapCount.containsKey(e.getBundesland())) {
        mapCount.put(e.getBundesland(),mapCount.get(e.getBundesland())+1);
      } else {
        mapCount.put(e.getBundesland(),1);
      }
    }

    Map<String,Integer> mapSum = new HashMap<>();
    int year = 2021; //kommt aus Date
    for(Einwohner e : list) {
      if(mapSum.containsKey(e.getBundesland())) {
        mapSum.put(e.getBundesland(),mapSum.get(e.getBundesland())+(year - e.getGeburtsjahr()));
      } else {
        mapSum.put(e.getBundesland(),year - e.getGeburtsjahr());
      }
    }

    Map<String,Integer> mapAvg = new HashMap<>();
    for(Map.Entry<String,Integer> e : mapCount.entrySet()) {
      mapAvg.put(e.getKey(),mapSum.get(e.getKey()) / mapCount.get(e.getKey()));
    }

    return mapAvg;

  }

}
