package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;

public class CharacterPhysics extends Physics {

  public CharacterPhysics(GameObject object) {
    super(object);
  }

  @Override
  public void move(Direction direction) {
    double     oldX      = object.getX();
    double     oldY      = object.getY();

    super.move(direction);

    if (isCollidedWithNearest() || isOutOfBounds())
      setPositionTo(oldX, oldY);
  }

  @Override
  public Bounds2D getInnerBounds() {
    Bounds2D bounds  = super.getInnerBounds();
    double   offsetY = 32.0D;
    double   offsetX = 8.0D;

    bounds.setY(bounds.getY() + offsetY);
    bounds.setHeight((int) (bounds.getHeight() - offsetY));
    bounds.setX(bounds.getX() + offsetX);
    bounds.setWidth((int) (bounds.getWidth() - (offsetX * 2)));

    return bounds;
  }

  @Override
  public Bounds2D getSpatialBounds() {
    Bounds2D bounds = super.getSpatialBounds();
    double   offset = 15D;

    bounds.setX(bounds.getX() - offset);
    bounds.setWidth((int) (bounds.getWidth() + (offset * 2)));

    bounds.setY(bounds.getY() - offset);
    bounds.setHeight((int) (bounds.getHeight() + (offset * 2)));

    return bounds;
  }

}
