package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.character.Values;
import org.nulllab.nullengine.openworld.object.direction.Direction;

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

    setDirectionSprite(direction);

    setX(getX() + velocityX);
    setY(getY() + velocityY);
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



}
