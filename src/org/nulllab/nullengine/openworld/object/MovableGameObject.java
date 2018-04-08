package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.character.Values;
import org.nulllab.nullengine.openworld.object.direction.Direction;

import java.util.EnumMap;
import java.util.Map;

public class MovableGameObject extends GameObject {

  public static final String VELOCITY = "VELOCITY";

  private Values                 values;
  private Map<Direction, String> directionMap;

  public MovableGameObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    this.values = new Values();
    this.directionMap = new EnumMap<>(Direction.class);

    this.directionMap.put(Direction.LEFT, Sprites.KEY_MOVE_WEST);
    this.directionMap.put(Direction.RIGHT, Sprites.KEY_MOVE_EAST);
    this.directionMap.put(Direction.UP, Sprites.KEY_MOVE_NORTH);
    this.directionMap.put(Direction.DOWN, Sprites.KEY_MOVE_SOUTH);

    setMovable(true);
    setVelocity(3D);
  }

  public void move(Direction direction) {
    double velocityX = (direction.getFactorX() * getVelocity());
    double velocityY = (direction.getFactorY() * getVelocity());

    setSprite(directionMap.get(direction));

    setX(getX() + velocityX);
    setY(getY() + velocityY);
  }

  public void setVelocity(double velocity) {
    values.setValue(VELOCITY, velocity);
  }

  public double getVelocity() {
    return values.getValue(VELOCITY);
  }

}
