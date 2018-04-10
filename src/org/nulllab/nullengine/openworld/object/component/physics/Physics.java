package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.component.Component;

import java.util.List;

public class Physics extends Component {

  public static final String VELOCITY = "VELOCITY";

  private Bounds2D outerBounds;

  public void move(Direction direction) {
    double     newX      = object.getX() + (direction.getFactorX() * getVelocity());
    double     newY      = object.getY() + (direction.getFactorY() * getVelocity());

    setPositionTo(newX, newY);
  }

  public void toCenter(double x, double y) {
    GameObject      object  = getGameObject();
    Bounds2D        outer   = getOuterBounds();
    double          offsetX = object.getWidth() / 2;
    double          offsetY = object.getHeight() / 2;
    double          newX    = Math.min(x, outer.getMaxX() - offsetX) - offsetX;
    double          newY    = Math.min(y, outer.getMaxY() - offsetY) - offsetY;

    setPositionTo(newX, newY);
  }

  public double getVelocity() {
    return getGameObject().getValue(VELOCITY);
  }

  public void setVelocity(double velocity) {
    getGameObject().setValue(VELOCITY, velocity);
  }

  public void setPositionTo(double x, double y) {
    GameObject object = getGameObject();
    object.setX(x);
    object.setY(y);
  }

  public Bounds2D getOuterBounds() {
    return outerBounds;
  }

  public Bounds2D getInnerBound() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  public Bounds2D getSpatialBounds() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  public void setOuterBounds(Bounds2D bounds) {
    this.outerBounds = bounds;
  }

  public void setGameObject(GameObject object) {
    super.setGameObject(object);
  }

  public CollisionDetector getCollisionDetector() {
    return getServiceLocator().getCollisionDetector();
  }

  public List<GameObject> getNearestObjects() {
    return getCollisionDetector().getNearestObjectsFor(getGameObject());
  }

  public List<GameObject> getNearestSolidObjects() {
    return getCollisionDetector().getNearestSolidObjectsFor(getGameObject());
  }

  public boolean isCollidedWithNearest() {
    return getCollisionDetector().isCollidedWithNearestSolid(getGameObject());
  }

  public boolean isOutOfBounds() {
    return getCollisionDetector().isOutOfBounds(getInnerBound(), getOuterBounds());
  }

  public boolean isOutOfBoundsX() {
    return getCollisionDetector().isOutOfBoundsX(getInnerBound(), getOuterBounds());
  }

  public boolean isOutOfBoundsY() {
    return getCollisionDetector().isOutOfBoundsY(getInnerBound(), getOuterBounds());
  }

}
