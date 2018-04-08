package org.nulllab.nullengine.openworld.state;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.object.GameObject;

public class ObjectState<O extends GameObject> {

  public void entryAction(O object) {}

  public void exitAction(O object) {}

  public ObjectState handle(O object, Input input) {
    return null;
  }

  public void update(O object) {

  }

}
