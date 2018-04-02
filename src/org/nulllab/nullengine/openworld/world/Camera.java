package org.nulllab.nullengine.openworld.world;

import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.openworld.object.ActiveObject;

public class Camera extends ActiveObject {

  public Camera(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public void syncPositionWith(double x, double y) {
    Bound2D areaBound = getAreaBound();
    Bound2D selfBound = getSelfBound();
    double  offsetX   = getWidth() / 2;
    double  offsetY   = getHeight() / 2;
    double  positionX = areaBound.getX();
    double  positionY = areaBound.getY();

    if (selfBound.getMaxX() > areaBound.getMaxX()) {

    }

    if (x > offsetX) {
      positionX = Math.min(x, areaBound.getMaxX() - offsetX) - offsetX;
    }

    if (y > offsetY) {
      positionY = Math.min(y, areaBound.getMaxY() - offsetY) - offsetY;
    }

    setX(positionX);
    setY(positionY);
  }

}
