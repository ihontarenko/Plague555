package org.nulllab.nullengine.core.geometry;

public class Point2D {

  protected int x;
  protected int y;

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("%s: {x: %d, y: %d}", Point2D.class.getSimpleName(), getX(), getY());
  }
}
