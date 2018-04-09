package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.collision.Collision;

public class CameraPhysics extends Physics {

  @Override
  public void toCenter(double x, double y) {
    GameObject object    = getGameObject();
    Collision  collision = (Collision) object.getCollision();

    // save old coordinates
    double oldX = object.getX();
    double oldY = object.getY();

    // update coordinates
    super.toCenter(x, y);

    // updated coordinates
    double newX = collision.isOutOfBoundsX() ? oldX : object.getX();
    double newY = collision.isOutOfBoundsY() ? oldY : object.getY();

    // reset position
    setPositionTo(newX, newY);
  }

}
