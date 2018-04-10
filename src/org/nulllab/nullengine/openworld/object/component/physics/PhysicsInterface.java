package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;

import java.util.List;

public interface PhysicsInterface {

  void move(Direction direction);

  void toCenter(double x, double y);

  void setPositionTo(double x, double y);

  double getVelocity();

  void setVelocity(double velocity);

  Bounds2D getOuterBounds();

  Bounds2D getInnerBound();

  Bounds2D getSpatialBounds();

  void setOuterBounds(Bounds2D bounds);

  CollisionDetector getCollisionDetector();

  List<GameObject> getNearestObjects();

  List<GameObject> getNearestSolidObjects();

  boolean isCollidedWithNearest();

  boolean isOutOfBounds();

  boolean isOutOfBoundsX();

  boolean isOutOfBoundsY();

}
