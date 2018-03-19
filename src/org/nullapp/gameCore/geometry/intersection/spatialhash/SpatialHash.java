package org.nullapp.gameCore.geometry.intersection.spatialhash;

import org.nullapp.gameCore.geometry.Bound2D;
import org.nullapp.gameCore.geometry.Object2D;
import org.nullapp.gameCore.geometry.intersection.IntersectionInterface;

import java.util.*;

@SuppressWarnings("unused")
public class SpatialHash implements IntersectionInterface {

  private static final int DEFAULT_SHIFT = 5; // pow(2, 5) = 32

  private int shift;
  private int inWidth;
  private int inHeight;
  private int size;

  private Map<Integer, List<Object2D>> objectHash;
  private Bound2D                      bound2D;

  public SpatialHash(Bound2D bound2D) {
    this(bound2D, DEFAULT_SHIFT);
  }

  public SpatialHash(Bound2D bound2D, int shift) {
    this.objectHash = new HashMap<>();
    this.bound2D = bound2D;
    this.shift = shift;
    this.inWidth = bound2D.getWidth() >> shift;
    this.inHeight = bound2D.getHeight() >> shift;
    this.size = 1 << shift;
  }

  @Override
  public List<Object2D> retrieve(Object2D object) {
    List<Object2D> results = new ArrayList<>();

    getObjectKeys(object).stream().filter(objectHash::containsKey).forEach(key -> results.addAll(objectHash.get(key)));

    return results;
  }

  public void updateObject2D(Object2D object2D) {
    List<Integer> keys = new ArrayList<>();

    objectHash.forEach((key, objectList) -> {
      if (objectList.contains(object2D)) {
        objectList.remove(object2D);
      }
    });

    insert(object2D);

    keys.forEach(System.out::println);
  }

  @Override
  public void insert(Object2D object) {
    getObjectKeys(object).forEach(key -> {
      if (objectHash.containsKey(key)) {
        objectHash.get(key).add(object);
      } else {
        objectHash.put(key, new ArrayList<>(Collections.singletonList(object)));
      }
    });
  }

  public List<Integer> getObjectKeys(Object2D object2D) {
    return this.getObjectKeys(object2D, shift);
  }

  public List<Integer> getObjectKeys(Object2D object2D, int shift) {
    List<Integer> keys = new ArrayList<>();

    int bx = bound2D.getX();
    int by = bound2D.getY();
    int sx = (object2D.getX() - bx) >> shift;
    int sy = (object2D.getY() - by) >> shift;
    int ex = (object2D.getMaxX() - bx) >> shift;
    int ey = (object2D.getMaxY() - by) >> shift;

    for (int y = sy; y <= ey; y++) {
      for (int x = sx; x <= ex; x++) {
        keys.add(y * inWidth() + x);
      }
    }

    return keys;
  }

  public int getXPosition(int key) {
    return key % inWidth();
  }

  public int getYPosition(int key) {
    return key / inWidth();
  }

  public int getXPixel(int key) {
    return getXPosition(key) * getSize() + getBound2D().getX();
  }

  public int getYPixel(int key) {
    return getYPosition(key) * getSize() + getBound2D().getY();
  }

  @Override
  public void clear() {
    objectHash = new HashMap<>();
  }

  public int inWidth() {
    return inWidth;
  }

  public int inHeight() {
    return inHeight;
  }

  public int getSize() {
    return size;
  }

  public Bound2D getBound2D() {
    return bound2D;
  }

}
