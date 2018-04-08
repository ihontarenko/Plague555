package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.character.Values;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.direction.Direction;

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
    double velocityX = (direction.getFactorX() * getVelocity());
    double velocityY = (direction.getFactorY() * getVelocity());
    double oldX      = getX();
    double oldY      = getY();
    double newX      = getX() + velocityX;
    double newY      = getY() + velocityY;

    setX(newX);
    setY(newY);

    if (isCollidedWithNearest()) {
      setX(oldX);
      setY(oldY);
    }

    setDirectionSprite(direction);
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

}
