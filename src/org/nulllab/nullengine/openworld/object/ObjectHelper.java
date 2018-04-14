package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Sprites;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static org.nulllab.nullengine.openworld.object.Direction.*;

public class ObjectHelper {

  private KeyMap keyMap;

  public ObjectHelper() {
    this.keyMap = new KeyMap();
    this.keyMap.initialize();
  }

  public KeyMap getDirectionMaps() {
    return keyMap;
  }

  public class KeyMap implements Initializable {

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

        spritesMap.put(LEFT, Sprites.KEY_MOVE_WEST);
        spritesMap.put(RIGHT, Sprites.KEY_MOVE_EAST);
        spritesMap.put(UP, Sprites.KEY_MOVE_NORTH);
        spritesMap.put(DOWN, Sprites.KEY_MOVE_SOUTH);

        keyMap.put(Input.LEFT, LEFT);
        keyMap.put(Input.RIGHT, RIGHT);
        keyMap.put(Input.UP, UP);
        keyMap.put(Input.DOWN, DOWN);

        initialized = true;
      }
    }

    @Override
    public void reinitialize() {

    }
  }

}
