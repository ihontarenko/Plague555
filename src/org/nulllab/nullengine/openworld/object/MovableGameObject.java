package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.character.Values;
import org.nulllab.nullengine.openworld.object.component.bounds.BoundsInterface;
import org.nulllab.nullengine.openworld.object.component.collision.CollisionDetection;
import org.nulllab.nullengine.openworld.object.geometry.Direction;

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
    CollisionDetection collisionDetection = (CollisionDetection) getCollisionDetection();
    double             oldX               = getX();
    double             oldY               = getY();
    double             newX               = getX() + (direction.getFactorX() * getVelocity());
    double             newY               = getY() + (direction.getFactorY() * getVelocity());

    setPositionTo(newX, newY);

    if (collisionDetection.isCollidedWithNearest() || collisionDetection.isOutOfBounds()) {
      setPositionTo(oldX, oldY);
    }

    getGraphics().setDirectionSprite(direction);
  }

  public void toCenter(double x, double y) {
    BoundsInterface bounds  = getBounds();
    Bounds2D        outer   = bounds.getOuterBounds();
    double          offsetX = getWidth() / 2;
    double          offsetY = getHeight() / 2;
    double          newX    = Math.min(x, outer.getMaxX() - offsetX) - offsetX;
    double          newY    = Math.min(y, outer.getMaxY() - offsetY) - offsetY;

    setPositionTo(newX, newY);
  }

  public void setPositionTo(double x, double y) {
    setX(x);
    setY(y);
  }

  public void setVelocity(double velocity) {
    values.setValue(VELOCITY, velocity);
  }

  public double getVelocity() {
    return values.getValue(VELOCITY);
  }



}
