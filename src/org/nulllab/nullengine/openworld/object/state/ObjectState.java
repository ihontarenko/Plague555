package org.nulllab.nullengine.openworld.object.state;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.object.GameObject;

abstract public class ObjectState<O extends GameObject> {

  public void entryAction(O object, Input input) {}

  public void exitAction(O object, Input input) {}

  public ObjectState handle(O object, Input input) {
    return null;
  }

  public void update(O object, Input input) {

  }

}
