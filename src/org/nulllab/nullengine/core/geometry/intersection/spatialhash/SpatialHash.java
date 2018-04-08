package org.nulllab.nullengine.core.geometry.intersection.spatialhash;

import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.geometry.intersection.IntersectionInterface;

import java.util.*;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class SpatialHash<T extends Object2D> implements IntersectionInterface<T> {

  private static final int DEFAULT_SHIFT = 5; // pow(2, 5) = 32

  private int shift;
  private int inWidth;
  private int inHeight;
  private int size;

  private Map<Integer, Set<T>> keyObjects;
  private Map<T, Set<Integer>> objectKeys;
  private Bound2D              bound2D;

  public SpatialHash(Bound2D bound2D) {
    this(bound2D, DEFAULT_SHIFT);
  }

  public SpatialHash(Bound2D bound2D, int shift) {
    this.keyObjects = new HashMap<>();
    this.objectKeys = new HashMap<>();
    this.bound2D = bound2D;
    this.shift = shift;
    this.inWidth = 1 + (bound2D.getWidth() >> shift);
    this.inHeight = 1 + (bound2D.getHeight() >> shift);
    this.size = 1 << shift;
  }

  @Override
  public Set<T> retrieve(Object2D object) {
    Set<T>          results = new HashSet<>();
    Stream<Integer> stream  = calculateObjectKeys(object).stream();

    stream.filter(keyObjects::containsKey).forEach(key -> results.addAll(keyObjects.get(key)));

    return results;
  }

  @Override
  public void insert(T object) {
    Set<Integer> keysSet = new HashSet<>();
    objectKeys.put(object, keysSet);

    for (Integer key : calculateObjectKeys(object)) {
      if (keyObjects.containsKey(key)) {
        keyObjects.get(key).add(object);
      } else {
        keyObjects.put(key, new HashSet<>(Collections.singleton(object)));
      }
      keysSet.add(key);
    }
  }

  @Override
  public void clear() {
    keyObjects = new HashMap<>();
  }

  public Set<Integer> calculateObjectKeys(Object2D object2D) {
    return calculateObjectKeys(object2D, shift);
  }

  public Set<Integer> calculateObjectKeys(Object2D object2D, int shift) {
    Set<Integer> keys = new HashSet<>();

    int bx = (int) bound2D.getX();
    int by = (int) bound2D.getY();

    int sx = ((int) object2D.getX() - bx) >> shift;
    int sy = ((int) object2D.getY() - by) >> shift;
    int ex = ((int) object2D.getMaxX() - bx) >> shift;
    int ey = ((int) object2D.getMaxY() - by) >> shift;

    for (int y = sy; y <= ey; y++) {
      for (int x = sx; x <= ex; x++) {
        keys.add(y * inWidth() + x);
      }
    }

    return keys;
  }

  public int inWidth() {
    return inWidth;
  }

  public void reinsert(T object) {
    remove(object);
    insert(object);
  }

  public void remove(T object) {
    Set<Integer> removeKeys;

    if (objectKeys.containsKey(object)) {
      removeKeys = objectKeys.get(object);

      for (Integer removeKey : removeKeys) {
        keyObjects.get(removeKey).remove(object);
      }

      objectKeys.remove(object);
    }
  }

  public Set<T> getObjects() {
    return objectKeys.keySet();
  }

  public Set<Integer> getObjectKeys(T object2D) {
    return objectKeys.get(object2D);
  }

  public double getXPixel(int key) {
    return getXPosition(key) * getSize() + getBound2D().getX();
  }

  public int getXPosition(int key) {
    return key % inWidth();
  }

  public int getSize() {
    return size;
  }

  public Bound2D getBound2D() {
    return bound2D;
  }

  public double getYPixel(int key) {
    return getYPosition(key) * getSize() + getBound2D().getY();
  }

  public int getYPosition(int key) {
    return key / inWidth();
  }

  public int inHeight() {
    return inHeight;
  }

}
