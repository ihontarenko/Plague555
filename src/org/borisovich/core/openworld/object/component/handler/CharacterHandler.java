package org.borisovich.core.openworld.object.component.handler;

import org.borisovich.core.core.input.Input;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.state.StandState;

public class CharacterHandler extends StateHandler {

  public CharacterHandler(GameObject object, Input input) {
    super(object, input);

    setState(new StandState());
  }

}
