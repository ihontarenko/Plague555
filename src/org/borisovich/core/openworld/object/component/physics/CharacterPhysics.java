package org.borisovich.core.openworld.object.component.physics;

import org.borisovich.core.core.event.Observable;
import org.borisovich.core.core.geometry.Bounds2D;
import org.borisovich.core.openworld.object.Direction;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.event.OnCollideEvent;

public class CharacterPhysics extends Physics {

  public CharacterPhysics(GameObject object) {
    super(object);
  }

  @Override
  public void move(Direction direction) {
    Observable<GameObject> observable = object.getObservable();
    double                 oldX       = object.getX();
    double                 oldY       = object.getY();

    super.move(direction);

    if (isCollidedWithNearest() || isOutOfBounds()) {
      setPositionTo(oldX, oldY);
      // todo: need move logic from here
      observable.notify(object, new OnCollideEvent());
    }
  }

  @Override
  public Bounds2D getInnerBounds() {
    Bounds2D bounds  = super.getInnerBounds();

    bounds.setY(bounds.getY() + getInnerOffsetY());
    bounds.setHeight((int) (bounds.getHeight() - getInnerOffsetY()));
    bounds.setX(bounds.getX() + getInnerOffsetX());
    bounds.setWidth((int) (bounds.getWidth() - (getInnerOffsetX() * 2)));

    return bounds;
  }

  @Override
  public Bounds2D getSpatialBounds() {
    Bounds2D bounds = super.getSpatialBounds();
    double   offset = 15D;

    bounds.setX(bounds.getX() - offset);
    bounds.setWidth((int) (bounds.getWidth() + (offset * 2)));

    bounds.setY(bounds.getY() - offset);
    bounds.setHeight((int) (bounds.getHeight() + (offset * 2)));

    return bounds;
  }

}
