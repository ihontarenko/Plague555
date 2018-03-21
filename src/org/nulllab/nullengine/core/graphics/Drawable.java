package org.nulllab.nullengine.core.graphics;

import org.nulllab.nullengine.core.geometry.Point2D;

public interface Drawable<Graphics extends Canvas> {

  public void draw(Graphics graphics, int x, int y);

  default void draw(Graphics graphics, Point2D point) {
    draw(graphics, point.getX(), point.getX());
  }

}
