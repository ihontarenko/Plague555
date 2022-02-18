package org.borisovich.core.openworld.object.state;

import org.borisovich.core.core.input.Input;
import org.borisovich.core.openworld.object.GameObject;

abstract public class ObjectState<O extends GameObject> {

  public void entryAction(O object, Input input) {}

  public void exitAction(O object, Input input) {}

  public ObjectState handle(O object, Input input) {
    return null;
  }

  public void update(O object, Input input) {

  }

}
