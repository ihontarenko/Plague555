package org.nulllab.nullengine.openworld.object.state;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.graphics.CharacterGraphics;
import org.nulllab.nullengine.openworld.object.component.physics.Physics;
import org.nulllab.nullengine.openworld.object.event.OnMoveEvent;

import java.util.Map;

public class MoveState extends ObjectState<Character> {

  private Integer                 lastPressedKey;
  private Map<Integer, Direction> keyMap;
  private int[]                   controlKeys;

  @Override
  public ObjectState handle(Character object, Input input) {
    ObjectState state = null;

    if (input.isReleased(controlKeys)) {
      state = new StandState();
    }

    return state;
  }

  @Override
  public void update(Character object, Input input) {
    Direction              direction  = getCurrentDirection(input);
    Observable<GameObject> observable = object.getObservable();
    Physics                physics    = object.getPhysics();
    CharacterGraphics      graphics   = (CharacterGraphics) object.getGraphics();

    physics.move(direction);
    graphics.setMoveDirectionSprite(direction);

    observable.notify(object, new OnMoveEvent());
  }

  @Override
  public void entryAction(Character object, Input input) {
    controlKeys = new int[]{Input.LEFT, Input.RIGHT, Input.UP, Input.DOWN};
    keyMap = object.getObjectHelper().getDirectionMaps().getKeyMapDirection();
  }

  @Override
  public void exitAction(Character object, Input input) {
    CharacterGraphics graphics = (CharacterGraphics) object.getGraphics();
    graphics.setStandDirectionSprite(getCurrentDirection(getLastPressedKey()));
  }

  private Direction getCurrentDirection(Input input) {
    return getCurrentDirection(input.getPressed());
  }

  private Direction getCurrentDirection(Integer pressedKey) {
    Direction direction = null;

    if (keyMap.containsKey(pressedKey)) {
      direction = keyMap.get(pressedKey);
    }

    setLastPressedKey(pressedKey);

    return direction;
  }

  private Integer getLastPressedKey() {
    return lastPressedKey;
  }

  private void setLastPressedKey(Integer lastPressedKey) {
    this.lastPressedKey = lastPressedKey;
  }
}
