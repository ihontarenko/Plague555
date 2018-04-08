package org.nulllab.nullengine.core.geometry;

public class Bounds2D extends Object2D {

  public Bounds2D(double x, double y, int width, int height) {
    super(x, y, width, height);
  }

  public boolean inBoundsX(double x) {
    return (x >= this.x && x <= this.getMaxX());
  }

  public boolean inBoundsX(Bounds2D bound) {
    return inBoundsX(bound.getX()) && inBoundsX(bound.getMaxX());
  }

  public boolean inBoundsY(double y) {
    return (y >= this.y && y <= this.getMaxY());
  }

  public boolean inBoundsY(Bounds2D bound) {
    return inBoundsY(bound.getY()) && inBoundsY(bound.getMaxY());
  }

  public boolean inBounds(double x, double y) {
    return inBoundsX(x) && inBoundsY(y);
  }

  public boolean inBounds(Bounds2D bound) {
    return inBoundsX(bound) && inBoundsY(bound);
  }

  public boolean intersects(Bounds2D bound) {
    return (bound.getMaxX() > this.x && bound.getMaxY() > this.y
        && bound.x < this.getMaxX() && bound.y < this.getMaxY());
  }

  public Bounds2D union(Bounds2D bound) {
    return new Bounds2D(Math.min(bound.x, this.x), Math.min(bound.y, this.y),
        Math.max(bound.width, this.width), Math.max(bound.height, this.height));
  }

  @Override
  public String toString() {
    return String.format("Bounds2D{ x:%s y:%s, w:%s h:%s }", this.x, this.y, this.width, this.height);
  }
}
