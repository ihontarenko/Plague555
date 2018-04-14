package org.nulllab.nullengine.openworld.object.component.input;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.object.GameObject;

public class CharacterHandler extends StateHandler {

  private Input input;

  public CharacterHandler(GameObject object, Input input) {
    super(object);
    this.input = input;
  }

  @Override
  public Input getInput() {
    return input;
  }

  public void setInput(Input input) {
    this.input = input;
  }
}
