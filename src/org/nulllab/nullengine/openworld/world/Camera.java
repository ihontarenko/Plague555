package org.nulllab.nullengine.openworld.world;

import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.openworld.object.MovableGameObject;

public class Camera extends MovableGameObject {

  public Camera(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public void toCenter(double x, double y) {
    // todo
    Bound2D worldBound = getBounds();

    double  offsetX   = getWidth() / 2;
    double  offsetY   = getHeight() / 2;
    double  positionX = worldBound.getX();
    double  positionY = worldBound.getY();

    if (x > offsetX) {
      positionX = Math.min(x, worldBound.getMaxX() - offsetX) - offsetX;
    }

    if (y > offsetY) {
      positionY = Math.min(y, worldBound.getMaxY() - offsetY) - offsetY;
    }

    setX(positionX);
    setY(positionY);
  }

}
