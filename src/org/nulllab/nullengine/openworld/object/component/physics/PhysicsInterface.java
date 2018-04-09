package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.openworld.object.Direction;

public interface PhysicsInterface {

  public void move(Direction direction);

  public void toCenter(double x, double y);

  public void setPositionTo(double x, double y);

  public double getVelocity();

  public void setVelocity(double velocity);

}
