package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.openworld.character.Values;

public class MovableGameObject extends GameObject {

  public static final String VELOCITY = "VELOCITY";

  private Values values;

  public MovableGameObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    setMovable(true);
  }

  public void move(double x, double y) {

  }

  public void setVelocity(double velocity) {
    values.setValue(VELOCITY, velocity);
  }

  public double getVelocity() {
    return values.getValue(VELOCITY);
  }

}
