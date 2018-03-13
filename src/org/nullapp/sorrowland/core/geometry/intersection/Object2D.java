package org.nullapp.sorrowland.core.geometry.intersection;

public interface Object2D extends Comparable<Object2D> {

  public double x();

  public double y();

  public double maxX();

  public double maxY();

  public void setX(double x);

  public void setY(double y);

  public double width();

  public double height();

  public double centreX();

  public double centreY();

}
