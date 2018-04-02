package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bound2D;

public class ActiveObject extends GameObject {

  private Bound2D areaBound;
  private Bound2D selfBound;

  public ActiveObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    setStatic(false);
  }

  public Bound2D getAreaBound() {
    return areaBound;
  }

  public void setAreaBound(Bound2D areaBound) {
    this.areaBound = areaBound;
  }

  public Bound2D getSelfBound() {
    return selfBound;
  }

  public void setSelfBound(Bound2D selfBound) {
//    selfBound.setX(getX());
//    selfBound.setY(getMaxY() - selfBound.getHeight());

    this.selfBound = selfBound;
  }
}
