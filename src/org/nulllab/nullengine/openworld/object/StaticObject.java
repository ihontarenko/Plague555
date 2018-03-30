package org.nulllab.nullengine.openworld.object;

public class StaticObject extends GameObject {

  public StaticObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    setStatic(true);
  }


}
