package org.nulllab.nullengine.openworld.object;

public class ActiveObject extends GameObject {

  public ActiveObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    setStatic(false);
  }

}
