package org.nulllab.nullengine.openworld.character.state;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;
import org.nulllab.nullengine.openworld.object.component.physics.Physics;
import org.nulllab.nullengine.openworld.state.ObjectState;

import java.util.Map;

public class MoveState extends ObjectState<Character> {

  private Map<Integer, Direction> keyMap;

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
    Direction             direction  = getCurrentDirection(object);
    Observable<Character> observable = object.getObservable();
    Physics               physics    = object.getPhysics();
    Graphics              graphics   = object.getGraphics();

    physics.move(direction);
    graphics.setDirectionSprite(direction);

    observable.notify(object);
  }

  @Override
  public void entryAction(Character object) {
    keyMap = object.getObjectHelper().getDirectionMaps().getKeyMapDirection();
  }

  @Override
  public void exitAction(Character object) {

  }

  private Direction getCurrentDirection(Character object) {
    Direction direction  = null;
    Integer   pressedKey = object.getInput().getPressed();

    if (keyMap.containsKey(pressedKey)) {
      direction = keyMap.get(pressedKey);
    }

    return direction;
  }

}
