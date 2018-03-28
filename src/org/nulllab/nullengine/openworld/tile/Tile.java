package org.nulllab.nullengine.openworld.tile;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.openworld.GameObject;

public class Tile extends GameObject {

  @Override
  public void render(Canvas canvas) {
    getSprite().draw(canvas, getX(), getY());
  }

}
