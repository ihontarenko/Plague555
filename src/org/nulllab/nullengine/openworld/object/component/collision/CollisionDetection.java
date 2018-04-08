package org.nulllab.nullengine.openworld.object.component.collision;

import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.component.bounds.BoundsInterface;

import java.util.List;

public class CollisionDetection extends Component implements CollisionDetectionInterface {

  private BoundsInterface bounds;

  @Override
  public void setGameObject(GameObject object) {
    super.setGameObject(object);
    bounds = object.getBounds();
  }

  @Override
  public CollisionDetector getCollisionDetector() {
    return getServiceLocator().getCollisionDetector();
  }

  @Override
  public List<GameObject> getNearestObjects() {
    return getCollisionDetector().getNearestObjectsFor(getGameObject());
  }

  @Override
  public List<GameObject> getNearestSolidObjects() {
    return getCollisionDetector().getNearestSolidObjectsFor(getGameObject());
  }

  @Override
  public boolean isCollidedWithNearest() {
    return getCollisionDetector().isCollidedWithNearestSolid(getGameObject());
  }

  @Override
  public boolean isOutOfBounds() {
    return getCollisionDetector().isOutOfBounds(bounds.getInnerBound(), bounds.getOuterBounds());
  }

  @Override
  public boolean isOutOfBoundsX() {
    return getCollisionDetector().isOutOfBoundsX(bounds.getInnerBound(), bounds.getOuterBounds());
  }

  @Override
  public boolean isOutOfBoundsY() {
    return getCollisionDetector().isOutOfBoundsY(bounds.getInnerBound(), bounds.getOuterBounds());
  }

}
