package org.nulllab.nullengine.openworld.character.state;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.state.ObjectState;

public class MoveState extends ObjectState<Character> {

  @Override
  public ObjectState handle(Character object, Input input) {
    ObjectState state = null;

    if (input.isReleased(new int[]{Input.LEFT, Input.RIGHT, Input.UP, Input.DOWN})) {
      state = new StandState();
    }

    return state;
  }

  @Override
  public void update(Character object) {
    Input  input    = object.getInput();
    double velocity = 0.2D;

    if (input.isPressed(Input.UP)) {
      object.setY(object.getY() - velocity);
      object.setSprite(object.getSpritePackage().getMoveNorth());
    } else if (input.isPressed(Input.DOWN)) {
      object.setY(object.getY() + velocity);
      object.setSprite(object.getSpritePackage().getMoveSouth());
    } else if (input.isPressed(Input.LEFT)) {
      object.setX(object.getX() - velocity);
      object.setSprite(object.getSpritePackage().getMoveWest());
    } else if (input.isPressed(Input.RIGHT)) {
      object.setX(object.getX() + velocity);
      object.setSprite(object.getSpritePackage().getMoveEast());
    }
  }
}
