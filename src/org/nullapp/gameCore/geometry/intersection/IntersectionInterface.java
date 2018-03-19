package org.nullapp.gameCore.geometry.intersection;

import org.nullapp.gameCore.geometry.Object2D;

import java.util.List;

public interface IntersectionInterface<T extends Object2D> {

  List<T> retrieve(T object);

  void insert(T object);

  void clear();

}
