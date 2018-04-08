package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.character.Values;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.geometry.Direction;

import java.util.List;
import java.util.Map;

public class MovableGameObject extends GameObject {

  public static final String VELOCITY = "VELOCITY";

  private Values                 values;
  private Map<Direction, String> spritesMap;

  public MovableGameObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    this.values = new Values();
    this.spritesMap = getObjectUtils().getMovement().getSpritesMapDirection();

    setMovable(true);
    setVelocity(3D);
  }

  public void move(Direction direction) {
    double oldX      = getX();
    double oldY      = getY();
    double newX      = getX() + (direction.getFactorX() * getVelocity());
    double newY      = getY() + (direction.getFactorY() * getVelocity());

    setPositionTo(newX, newY);

    if (isCollidedWithNearest() || isOutOfBounds()) {
      setPositionTo(oldX, oldY);
    }

    setDirectionSprite(direction);
  }

  public void toCenter(double x, double y) {
    Bounds2D outer = getOuterBounds();

    double oldX = getX();
    double oldY = getY();
    double offsetX = getWidth() / 2;
    double offsetY = getHeight() / 2;
    double newX = Math.min(x, outer.getMaxX() - offsetX) - offsetX;
    double newY = Math.min(y, outer.getMaxY() - offsetY) - offsetY;

    setPositionTo(newX, newY);

    if (isOutOfBoundsX() || isOutOfBoundsY()) {
      newX = isOutOfBoundsX() ? oldX : newX;
      newY = isOutOfBoundsY() ? oldY : newY;
    }

    setPositionTo(newX, newY);
  }

  public void setPositionTo(double x, double y) {
    setX(x);
    setY(y);
  }

  public void setDirectionSprite(Direction direction) {
    Sprites sprites = getObjectSprites();
    setSprite(sprites.getSprite(spritesMap.get(direction)));
  }

  public void setVelocity(double velocity) {
    values.setValue(VELOCITY, velocity);
  }

  public double getVelocity() {
    return values.getValue(VELOCITY);
  }

  public CollisionDetector getCollisionDetector() {
    return getServiceLocator().getCollisionDetector();
  }

  public List<GameObject> getNearestObjects() {
    return getCollisionDetector().getNearestObjectsFor(this);
  }

  public List<GameObject> getNearestSolidObjects() {
    return getCollisionDetector().getNearestSolidObjectsFor(this);
  }

  public boolean isCollidedWithNearest() {
    return getCollisionDetector().isCollidedWithNearestSolid(this);
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
