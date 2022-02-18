package org.borisovich.core.openworld.object.component.physics;

import org.borisovich.core.core.geometry.Bounds2D;
import org.borisovich.core.openworld.object.Direction;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.collision.CollisionDetector;
import org.borisovich.core.openworld.object.component.Component;

import java.util.List;

public class Physics extends Component {

  public static final String VELOCITY     = "VELOCITY";
  private             double innerOffsetY = 32.0D;
  private             double innerOffsetX = 8.0D;
  private Bounds2D outerBounds;

  public Physics(GameObject object) {
    super(object);
  }

  public double getInnerOffsetY() {
    return innerOffsetY;
  }

  public void setInnerOffsetY(double innerOffsetY) {
    this.innerOffsetY = innerOffsetY;
  }

  public double getInnerOffsetX() {
    return innerOffsetX;
  }

  public void setInnerOffsetX(double innerOffsetX) {
    this.innerOffsetX = innerOffsetX;
  }

  public void move(Direction direction) {
    double newX = object.getX() + (direction.getFactorX() * getVelocity());
    double newY = object.getY() + (direction.getFactorY() * getVelocity());

    setPositionTo(newX, newY);
  }

  public void toCenter(double x, double y) {
    GameObject object  = getGameObject();
    Bounds2D   outer   = getOuterBounds();
    double     offsetX = object.getWidth() / 2;
    double     offsetY = object.getHeight() / 2;
    double     newX    = Math.min(x, outer.getMaxX() - offsetX) - offsetX;
    double     newY    = Math.min(y, outer.getMaxY() - offsetY) - offsetY;

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

  public void setOuterBounds(Bounds2D bounds) {
    this.outerBounds = bounds;
  }

  public Bounds2D getInnerBounds() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  public Bounds2D getSpatialBounds() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
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
    return getCollisionDetector().isOutOfBounds(getInnerBounds(), getOuterBounds());
  }

  public boolean isOutOfBoundsX() {
    return getCollisionDetector().isOutOfBoundsX(getInnerBounds(), getOuterBounds());
  }

  public boolean isOutOfBoundsY() {
    return getCollisionDetector().isOutOfBoundsY(getInnerBounds(), getOuterBounds());
  }

}
