package org.nulllab.nullengine.openworld.object.component.bounds;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.component.Component;

public class Bounds extends Component implements BoundsInterface {

  private Bounds2D outerBounds;

  @Override
  public Bounds2D getOuterBounds() {
    return outerBounds;
  }

  @Override
  public Bounds2D getInnerBound() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  @Override
  public Bounds2D getSpatialBounds() {
    return new Bounds2D(object.getX(), object.getY(), object.getWidth(), object.getHeight());
  }

  @Override
  public void setOuterBounds(Bounds2D bounds) {
    this.outerBounds = bounds;
  }

}
