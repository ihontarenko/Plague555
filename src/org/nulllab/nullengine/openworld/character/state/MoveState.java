package org.nulllab.nullengine.openworld.character.state;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.component.physics.Physics;
import org.nulllab.nullengine.openworld.state.ObjectState;

import java.util.Map;

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
    Physics                 physics    = object.getPhysics();
    Map<Integer, Direction> map        = object.getObjectHelper().getDirectionMaps().getKeyMapDirection();
    Integer                 pressedKey = object.getInput().getPressed();

    if (map.containsKey(pressedKey)) {
      physics.move(map.get(pressedKey));
      object.getObservable().notify(object);
    }
  }
}
