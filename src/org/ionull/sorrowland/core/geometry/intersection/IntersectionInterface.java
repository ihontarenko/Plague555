package org.ionull.sorrowland.core.geometry.intersection;

import java.util.List;

public interface IntersectionInterface<T extends Object2D & Comparable<Object2D>> {

  List<T> retrieve(T object);

  void insert(T object);

  void clear();

}
