package org.nulllab.nullengine.openworld.tile;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.component.GraphicComponent;
import org.nulllab.nullengine.openworld.component.InputComponent;
import org.nulllab.nullengine.openworld.state.ObjectState;

public class Tile extends GameObject {

  public Tile(ObjectState state, InputComponent input, GraphicComponent graphic) {
    super(state, input, graphic);
  }

  @Override
  public void render(Canvas canvas) {
    getSprite().draw(canvas, getX(), getY());
  }

}
