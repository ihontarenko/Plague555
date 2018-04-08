package org.nulllab.nullengine.openworld.object.component.collision;

import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.component.bounds.BoundsInterface;

import java.util.List;

public class Collision extends Component implements CollisionInterface {

  @Override
  public void setGameObject(GameObject object) {
    super.setGameObject(object);
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
    BoundsInterface   bounds   = getGameObject().getBounds();
    CollisionDetector detector = getCollisionDetector();

    return detector.isOutOfBounds(bounds.getInnerBound(), bounds.getOuterBounds());
  }

  @Override
  public boolean isOutOfBoundsX() {
    BoundsInterface   bounds   = getGameObject().getBounds();
    CollisionDetector detector = getCollisionDetector();

    return detector.isOutOfBoundsX(bounds.getInnerBound(), bounds.getOuterBounds());
  }

  @Override
  public boolean isOutOfBoundsY() {
    BoundsInterface   bounds   = getGameObject().getBounds();
    CollisionDetector detector = getCollisionDetector();

    return detector.isOutOfBoundsY(bounds.getInnerBound(), bounds.getOuterBounds());
  }

}
