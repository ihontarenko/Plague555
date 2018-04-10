package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.component.Component;

import java.util.List;

public class Physics extends Component implements PhysicsInterface {

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

  public void setPositionTo(double x, double y) {
    GameObject object = getGameObject();
    object.setX(x);
    object.setY(y);
  }

  public void setVelocity(double velocity) {
    getGameObject().setValue(VELOCITY, velocity);
  }

  @Override
  public Bounds2D getOuterBounds() {
    return outerBounds;
  }

  @Override
  public Bounds2D getInnerBound() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  @Override
  public Bounds2D getSpatialBounds() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  @Override
  public void setOuterBounds(Bounds2D bounds) {
    this.outerBounds = bounds;
  }

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
    return getCollisionDetector().isOutOfBounds(getInnerBound(), getOuterBounds());
  }

  @Override
  public boolean isOutOfBoundsX() {
    return getCollisionDetector().isOutOfBoundsX(getInnerBound(), getOuterBounds());
  }

  @Override
  public boolean isOutOfBoundsY() {
    return getCollisionDetector().isOutOfBoundsY(getInnerBound(), getOuterBounds());
  }

}
