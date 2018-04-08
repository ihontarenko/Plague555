package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.object.geometry.Direction;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class GameObjectUtils {

  private MovementUtils movement;

  public GameObjectUtils() {
    this.movement = new MovementUtils();
    this.movement.initialize();
  }

  public MovementUtils getMovement() {
    return movement;
  }

  public class MovementUtils implements Initializable {

    private Map<Direction, String>  spritesMap;
    private Map<Integer, Direction> keyMap;
    private boolean                 initialized;

    public Map<Direction, String> getSpritesMapDirection() {
      return spritesMap;
    }

    public Map<Integer, Direction> getKeyMapDirection() {
      return keyMap;
    }

    @Override
    public boolean isInitialized() {
      return initialized;
    }

    @Override
    public void initialize() {
      if (!isInitialized()) {
        keyMap = new HashMap<>();
        spritesMap = new EnumMap<>(Direction.class);

        spritesMap.put(Direction.LEFT, Sprites.KEY_MOVE_WEST);
        spritesMap.put(Direction.RIGHT, Sprites.KEY_MOVE_EAST);
        spritesMap.put(Direction.UP, Sprites.KEY_MOVE_NORTH);
        spritesMap.put(Direction.DOWN, Sprites.KEY_MOVE_SOUTH);

        keyMap.put(Input.LEFT, Direction.LEFT);
        keyMap.put(Input.RIGHT, Direction.RIGHT);
        keyMap.put(Input.UP, Direction.UP);
        keyMap.put(Input.DOWN, Direction.DOWN);

        initialized = true;
      }
    }

    @Override
    public void reinitialize() {

    }
  }

}
