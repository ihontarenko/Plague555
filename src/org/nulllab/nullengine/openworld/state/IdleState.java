package org.nulllab.nullengine.openworld.state;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.GameObject;

public class IdleState extends ObjectState {

  @Override
  public void entryAction(GameObject gameObject) {
    System.out.println("entry: " + getClass().getSimpleName());
  }

  @Override
  public void exitAction(GameObject gameObject) {
    System.out.println("exit: " + getClass().getSimpleName());
  }

  @Override
  public ObjectState handle(GameObject gameObject, Input input) {
    ObjectState state = null;

    if (input.isPressed(Input.BUTTON_0)) {
      state = new MovementState();
    }

    return state;
  }

}
