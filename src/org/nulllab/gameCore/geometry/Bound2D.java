package org.nulllab.gameCore.geometry;

public class Bound2D extends Object2D {

  public Bound2D(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public boolean contains(double x, double y) {
    return (x >= this.x && y >= this.y && x <= this.getMaxX() && y <= this.getMaxY());
  }

  public boolean intersects(Bound2D bound) {
    return (bound.getMaxX() > this.x && bound.getMaxY() > this.y
        && bound.x < this.getMaxX() && bound.y < this.getMaxY());
  }

  public Bound2D union(Bound2D bound) {
    return new Bound2D(Math.min(bound.x, this.x), Math.min(bound.y, this.y),
        Math.max(bound.width, this.width), Math.max(bound.height, this.height));
  }

  @Override
  public String toString() {
    return String.format("Bound2D{ getX:%s getY:%s, w:%s h:%s }", this.x, this.x, this.width,
        this.height);
  }
}
