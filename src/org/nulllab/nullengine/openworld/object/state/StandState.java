package org.nulllab.nullengine.openworld.object.state;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;

public class StandState extends ObjectState<Character> {

  @Override
  public void entryAction(Character object, Input input) {
    Graphics graphics      = object.getGraphics();
    Sprite   defaultSprite = graphics.getObjectSprites().getDefaultSprite();

    graphics.setSprite(defaultSprite);
  }

  @Override
  public ObjectState handle(Character object, Input input) {
    ObjectState state = null;

    if (input.isPressed(new int[]{Input.LEFT, Input.RIGHT, Input.UP, Input.DOWN})) {
      state = new MoveState();
    }

    return state;
  }
}
