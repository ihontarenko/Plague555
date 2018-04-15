package org.nulllab.nullengine.openworld.object.component.handler;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.state.StandState;

public class CharacterHandler extends StateHandler {

  public CharacterHandler(GameObject object, Input input) {
    super(object, input);

    setState(new StandState());
  }

}
