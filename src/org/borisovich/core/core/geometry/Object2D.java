package org.borisovich.core.core.geometry;

public class Object2D extends Point2D {

  protected int width;
  protected int height;

  public Object2D(double x, double y, int width, int height) {
    super(x, y);

    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public double getCentreX() {
    return (this.x + this.getMaxX()) / 2;
  }

  public double getMaxX() {
    return this.x + this.width;
  }

  public double getCentreY() {
    return (this.y + this.getMaxY()) / 2;
  }

  public double getMaxY() {
    return this.y + this.height;
  }

  @Override
  public String toString() {
    return String.format("%s: {super: %s, maxX: %f, maxY: %f}",
        Object2D.class.getSimpleName(), super.toString(), getMaxX(), getMaxY());
  }

}
