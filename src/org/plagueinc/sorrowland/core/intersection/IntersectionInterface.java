package org.plagueinc.sorrowland.core.intersection;

import java.util.List;

public interface IntersectionInterface<T extends Object2D & Comparable<T>> {

  List<T> retrieve(T object);

  void insert(T object);

  void clear();

}
