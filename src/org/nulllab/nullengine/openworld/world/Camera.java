package org.nulllab.nullengine.openworld.world;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.component.GraphicComponent;
import org.nulllab.nullengine.openworld.component.InputComponent;
import org.nulllab.nullengine.openworld.state.ObjectState;

public class Camera extends GameObject {

  public Camera(ObjectState state, InputComponent input, GraphicComponent graphic) {
    super(state, input, graphic);
  }

  @Override
  public void render(Canvas canvas) {

  }

  @Override
  public void update(float nano) {

  }

}
