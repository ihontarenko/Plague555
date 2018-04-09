package org.nulllab.nullengine.openworld.object.component.physics;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.component.bounds.BoundsInterface;

public class Physics extends Component implements PhysicsInterface {

  public static final String VELOCITY = "VELOCITY";

  public void move(Direction direction) {
    double     newX      = object.getX() + (direction.getFactorX() * getVelocity());
    double     newY      = object.getY() + (direction.getFactorY() * getVelocity());

    setPositionTo(newX, newY);
  }

  public void toCenter(double x, double y) {
    GameObject      object  = getGameObject();
    BoundsInterface bounds  = object.getBounds();
    Bounds2D        outer   = bounds.getOuterBounds();
    double          offsetX = object.getWidth() / 2;
    double          offsetY = object.getHeight() / 2;
    double          newX    = Math.min(x, outer.getMaxX() - offsetX) - offsetX;
    double          newY    = Math.min(y, outer.getMaxY() - offsetY) - offsetY;

    setPositionTo(newX, newY);
  }

  public double getVelocity() {
    return getGameObject().getValue(VELOCITY);
  }

  public void setPositionTo(double x, double y) {
    GameObject object = getGameObject();
    object.setX(x);
    object.setY(y);
  }

  public void setVelocity(double velocity) {
    getGameObject().setValue(VELOCITY, velocity);
  }

}
