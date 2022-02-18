package org.borisovich.core.core.geometry.intersection;

import org.borisovich.core.core.geometry.Object2D;

import java.util.Set;

public interface IntersectionInterface<T extends Object2D> {

  Set<T> retrieve(T object);

  void insert(T object);

  void clear();

}
