package com.nullion.appcore.geometry;

public class Dimension {

  private int width  = 0;
  private int height = 0;

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
    return String.format("[%s]: (width: %d, height: %d)", getClass().getName(), getWidth(), getHeight());
  }
}
