package org.borisovich.core.core.graphics;

import org.borisovich.core.core.geometry.Point2D;

public interface Drawable<Graphics extends Canvas> {

  public void draw(Graphics graphics, double x, double y);

  default void draw(Graphics graphics, Point2D point) {
    draw(graphics, point.getX(), point.getX());
  }

}
