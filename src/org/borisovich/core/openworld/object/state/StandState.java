package org.borisovich.core.openworld.object.state;

import org.borisovich.core.core.input.Input;
import org.borisovich.core.openworld.character.Character;
import org.borisovich.core.openworld.object.component.graphics.Graphics;

public class StandState extends ObjectState<Character> {

  private static int[] controlKeys;

  static {
    controlKeys = new int[]{Input.LEFT, Input.RIGHT, Input.UP, Input.DOWN};
  }

  @Override
  public void entryAction(Character object, Input input) {
    Graphics graphics = object.getGraphics();

    if (graphics.getSprite() == null) {
      graphics.setSprite(graphics.getObjectSprites().getDefaultSprite());
    }
  }

  @Override
  public ObjectState handle(Character object, Input input) {
    ObjectState state = null;

    if (input.isPressed(controlKeys)) {
      state = new MoveState();
    }

    return state;
  }
}
