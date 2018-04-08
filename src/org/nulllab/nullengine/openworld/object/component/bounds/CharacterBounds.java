package org.nulllab.nullengine.openworld.object.component.bounds;

import org.nulllab.nullengine.core.geometry.Bounds2D;

public class CharacterBounds extends Bounds {

  @Override
  public Bounds2D getInnerBound() {
    Bounds2D bounds = super.getInnerBound();
    double   offset = bounds.getHeight() / 2;

    bounds.setY(bounds.getY() + offset);
    bounds.setHeight((int) offset);

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
