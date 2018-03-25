package org.nulllab.nullengine.openworld.state;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.GameObject;

public class ObjectState implements Renderable<Canvas>, Updateable {

  public void entryAction(GameObject gameObject) {

  }

  public void exitAction(GameObject gameObject) {

  }

  public ObjectState handle(GameObject gameObject, Input input) {
    return null;
  }

  @Override
  public void render(Canvas g2d) {

  }

  @Override
  public void update(float nano) {

  }

}
