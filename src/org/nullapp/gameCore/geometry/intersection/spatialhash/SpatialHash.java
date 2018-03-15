package org.nullapp.gameCore.geometry.intersection.spatialhash;

import org.nullapp.gameCore.geometry.intersection.IntersectionInterface;
import org.nullapp.gameCore.geometry.intersection.Object2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpatialHash implements IntersectionInterface {

  final public static int SHIFT = 5;

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

    int sx = (int) box.getX() >> SHIFT,
        sy = (int) box.getY() >> SHIFT,
        ex = (int) (box.getX() + box.getWidth()) >> SHIFT,
        ey = (int) (box.getY() + box.getHeight()) >> SHIFT;

    List<String> keys = new ArrayList<>();

    for (int y = sy; y <= ey; y++) {
      for (int x = sx; x <= ex; x++) {
        keys.add(x + ":" + y);
      }
    }
    return keys;
  }

  public List<String> getFlatHash(Rectangle box) {

    int sx = (int) box.getX() >> SHIFT,
        sy = (int) box.getY() >> SHIFT,
        ex = (int) (box.getX() + box.getWidth()) >> SHIFT,
        ey = (int) (box.getY() + box.getHeight()) >> SHIFT;

    List<String> keys = new ArrayList<>();

    for (int y = sy; y <= ey; y++) {
      for (int x = sx; x <= ex; x++) {
        keys.add(x + ":" + y);
      }
    }
    return keys;
  }

}
