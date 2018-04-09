package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.component.collision.Collision;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;

public class CharacterPhysics extends Physics {

  @Override
  public void move(Direction direction) {
    Collision  collision = (Collision) object.getCollision();
    Graphics   graphics  = (Graphics) object.getGraphics();

    double     oldX      = object.getX();
    double     oldY      = object.getY();

    super.move(direction);

    if (collision.isCollidedWithNearest() || collision.isOutOfBounds()) {
      setPositionTo(oldX, oldY);
    }

    graphics.setDirectionSprite(direction);
  }
}
