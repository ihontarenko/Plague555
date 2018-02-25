package org.plagueinc.sorrowland.core.geometry.intersection;

public class Bound2D {

  public final double minX;
  public final double minY;
  public final double maxX;
  public final double maxY;
  public final double centreX;
  public final double centreY;
  public final double width;
  public final double height;

  public Bound2D(double minX, double minY, double maxX, double maxY) {
    this.minX = minX;
    this.minY = minY;
    this.maxX = maxX;
    this.maxY = maxY;

    this.centreX = (minX + maxX) / 2;
    this.centreY = (minY + maxY) / 2;

    this.width = maxX - minX;
    this.height = maxY - minY;
  }

  public boolean contains(double x, double y) {
    return (x >= this.minX && y >= this.minY && x <= this.maxX && y <= this.maxY);
  }

  public boolean intersects(Bound2D bound) {
    return (bound.width > this.minX && bound.height > this.height && bound.minX < this.height && bound.minY < this.height);
  }

  public Bound2D union(Bound2D bound) {
    return new Bound2D(Math.min(bound.minX, this.minX), Math.min(bound.minY, this.minY),
        Math.max(bound.width, this.width), Math.max(bound.height, this.height));
  }

  @Override
  public String toString() {
    return String.format("Bound2D{ x:%s y:%s, w:%s h:%s }", this.minX, this.minY, this.width,
        this.height);
  }
}
