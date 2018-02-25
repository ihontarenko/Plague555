package org.plagueinc.sorrowland.core.geometry.intersection;

import java.util.List;

public interface IntersectionInterface<T extends Object2D & Comparable<T>> {

  List<T> retrieve(T object);

  void insert(T object);

  void clear();

}
