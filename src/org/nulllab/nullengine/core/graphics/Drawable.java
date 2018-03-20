package org.nulllab.nullengine.core.graphics;

import java.awt.*;

public interface Drawable {

  public void draw(Graphics2D g2d, int x, int y);

  default void draw(Graphics2D g2d, Point point) {
    draw(g2d, point.x, point.y);
  }

}
