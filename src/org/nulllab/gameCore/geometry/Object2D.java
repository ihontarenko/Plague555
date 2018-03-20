package org.nulllab.gameCore.geometry;

public class Object2D extends Point2D {

  protected int width;
  protected int height;

  public Object2D(int x, int y, int width, int height) {
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

  public int getCentreX() {
    return (this.x + this.getMaxX()) / 2;
  }

  public int getMaxX() {
    return this.x + this.width;
  }

  public int getCentreY() {
    return (this.y + this.getMaxY()) / 2;
  }

  public int getMaxY() {
    return this.y + this.height;
  }

  @Override
  public String toString() {
    return String.format("%s: {super: %s, maxX: %d, maxY: %d}",
        Object2D.class.getSimpleName(), super.toString(), getMaxX(), getMaxY());
  }

}
