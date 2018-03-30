package org.nulllab.nullengine.openworld.world;

import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.openworld.object.ActiveObject;

public class Camera extends ActiveObject {

  public Camera(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public void syncPositionWith(double x, double y) {
    Bound2D bound2D   = getBound2D();
    double  offsetX   = getWidth() / 2;
    double  offsetY   = getHeight() / 2;
    double  positionX = bound2D.getX();
    double  positionY = bound2D.getY();

    if (x > offsetX) {
      positionX = Math.min(x, bound2D.getMaxX() - offsetX) - offsetX;
    }

    if (y > offsetY) {
      positionY = Math.min(y, bound2D.getMaxY() - offsetY) - offsetY;
    }

    setX(positionX);
    setY(positionY);
  }

}
