package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Sprites;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ObjectHelper {

  private Direction direction;

  public ObjectHelper() {
    this.direction = new Direction();
    this.direction.initialize();
  }

  public Direction getDirectionMaps() {
    return direction;
  }

  public class Direction implements Initializable {

    private Map<org.nulllab.nullengine.openworld.object.Direction, String>  spritesMap;
    private Map<Integer, org.nulllab.nullengine.openworld.object.Direction> keyMap;
    private boolean                                                         initialized;

    public Map<org.nulllab.nullengine.openworld.object.Direction, String> getSpritesMapDirection() {
      return spritesMap;
    }

    public Map<Integer, org.nulllab.nullengine.openworld.object.Direction> getKeyMapDirection() {
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
        spritesMap = new EnumMap<>(org.nulllab.nullengine.openworld.object.Direction.class);

        spritesMap.put(org.nulllab.nullengine.openworld.object.Direction.LEFT, Sprites.KEY_MOVE_WEST);
        spritesMap.put(org.nulllab.nullengine.openworld.object.Direction.RIGHT, Sprites.KEY_MOVE_EAST);
        spritesMap.put(org.nulllab.nullengine.openworld.object.Direction.UP, Sprites.KEY_MOVE_NORTH);
        spritesMap.put(org.nulllab.nullengine.openworld.object.Direction.DOWN, Sprites.KEY_MOVE_SOUTH);

        keyMap.put(Input.LEFT, org.nulllab.nullengine.openworld.object.Direction.LEFT);
        keyMap.put(Input.RIGHT, org.nulllab.nullengine.openworld.object.Direction.RIGHT);
        keyMap.put(Input.UP, org.nulllab.nullengine.openworld.object.Direction.UP);
        keyMap.put(Input.DOWN, org.nulllab.nullengine.openworld.object.Direction.DOWN);

        initialized = true;
      }
    }

    @Override
    public void reinitialize() {

    }
  }

}
