package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bound2D;

public class ActiveObject extends GameObject {

  private Bound2D bound2D;

  public ActiveObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    setStatic(false);
  }

  public Bound2D getBound2D() {
    return bound2D;
  }

  public void setBound2D(Bound2D bound2D) {
    this.bound2D = bound2D;
  }

}
