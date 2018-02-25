package org.plagueinc.sl.core.spatialhash;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpatialHash {

  public List<String> getHash(Rectangle box) {

    int shift = 5;

    int sx = (int) box.getX() >> shift,
        sy = (int) box.getY() >> shift,
        ex = (int) (box.getX() + box.getWidth()) >> shift,
        ey = (int) (box.getY() + box.getHeight()) >> shift;
    List<String> keys = new ArrayList<>();
    for (int y = sy; y <= ey; y++) {
      for (int x = sx; x <= ex; x++) {
        keys.add(x + ":" + y);
      }
    }
    return keys;
  }

}
