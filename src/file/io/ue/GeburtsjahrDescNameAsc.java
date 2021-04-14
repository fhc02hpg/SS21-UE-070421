package file.io.ue;

import java.util.Comparator;

public class GeburtsjahrDescNameAsc implements Comparator<Einwohner> {

  @Override
  public int compare(Einwohner o1, Einwohner o2) {
    int cmpGeb = Integer.compare(o2.getGeburtsjahr(),o1.getGeburtsjahr());
    if(cmpGeb == 0) {
      return o1.getName().compareTo(o2.getName());
    }
    return cmpGeb;
  }
}
