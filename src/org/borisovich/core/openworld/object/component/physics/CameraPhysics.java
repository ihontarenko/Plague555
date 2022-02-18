package org.borisovich.core.openworld.object.component.physics;

import org.borisovich.core.openworld.object.GameObject;

public class CameraPhysics extends Physics {

  public CameraPhysics(GameObject object) {
    super(object);
  }

  @Override
  public void toCenter(double x, double y) {
    GameObject object    = getGameObject();

    // save old coordinates
    double oldX = object.getX();
    double oldY = object.getY();

    // update coordinates
    super.toCenter(x, y);

    // updated coordinates
    double newX = isOutOfBoundsX() ? oldX : object.getX();
    double newY = isOutOfBoundsY() ? oldY : object.getY();

    // reset position
    setPositionTo(newX, newY);
  }

}
