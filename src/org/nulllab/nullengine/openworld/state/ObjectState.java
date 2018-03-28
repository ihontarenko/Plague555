package org.nulllab.nullengine.openworld.state;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.GameObject;

public class ObjectState<O extends GameObject> {

  public void entryAction(O object) {
    System.out.println("entry: " + this.getClass().getSimpleName());
  }

  public void exitAction(O object) {
    System.out.println("exit: " + this.getClass().getSimpleName());
  }

  public ObjectState handle(O object, Input input) {
    return null;
  }

  public void update(O object) {

  }

}
