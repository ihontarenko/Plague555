package org.nulllab.nullengine.openworld.object.component.collision;

import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;

import java.util.List;

public interface CollisionDetectionInterface {

  CollisionDetector getCollisionDetector();

  List<GameObject> getNearestObjects();

  List<GameObject> getNearestSolidObjects();

  boolean isCollidedWithNearest();

  boolean isOutOfBounds();

  boolean isOutOfBoundsX();

  boolean isOutOfBoundsY();
}
