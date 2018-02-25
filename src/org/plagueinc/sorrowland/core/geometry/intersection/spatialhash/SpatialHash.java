package org.plagueinc.sorrowland.core.geometry.intersection.spatialhash;

import org.plagueinc.sorrowland.core.geometry.intersection.IntersectionInterface;
import org.plagueinc.sorrowland.core.geometry.intersection.Object2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpatialHash implements IntersectionInterface{

  @Override
  public List<Object2D> retrieve(Object2D object) {
    return null;
  }

  @Override
  public void insert(Object2D object) {

  }

  @Override
  public void clear() {

  }

  public List<String> getHash(Rectangle box) {

    int shift = 3;

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
