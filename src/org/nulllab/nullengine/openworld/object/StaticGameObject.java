package org.nulllab.nullengine.openworld.object;

public class StaticGameObject extends GameObject {

  public StaticGameObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    setMovable(false);
  }


}
