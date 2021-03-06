package org.borisovich.core.core.geometry;

public class Dimension {

  private int width;
  private int height;

  public Dimension(double width, double height) {
    this((int)width, (int)height);
  }

  public Dimension(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public boolean equals(Object dimension) {
    boolean isEquals = false;

    if (dimension instanceof Dimension) {
      isEquals = (((Dimension) dimension).height == this.height && ((Dimension) dimension).width == this.width);
    }

    return isEquals;
  }

  @Override
  public String toString() {
    return String.format("[%s]: (getWidth: %d, getHeight: %d)", getClass().getName(), getWidth(), getHeight());
  }
}
