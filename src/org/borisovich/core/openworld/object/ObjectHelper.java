package org.borisovich.core.openworld.object;

import org.borisovich.core.core.common.Initializable;
import org.borisovich.core.core.input.Input;
import org.borisovich.core.openworld.character.Sprites;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

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

    private Map<Direction, String>  standSpritesMap;
    private Map<Direction, String>  moveSpritesMap;
    private Map<Integer, Direction> keyMap;
    private boolean                 initialized;

    public Map<Direction, String> getSpritesMapDirectionOnMove() {
      return moveSpritesMap;
    }

    public Map<Direction, String> getSpritesMapDirectionOnStand() {
      return standSpritesMap;
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
        moveSpritesMap = new EnumMap<>(Direction.class);
        standSpritesMap = new EnumMap<>(Direction.class);
        keyMap = new HashMap<>();

        moveSpritesMap.put(Direction.LEFT, Sprites.KEY_MOVE_WEST);
        moveSpritesMap.put(Direction.RIGHT, Sprites.KEY_MOVE_EAST);
        moveSpritesMap.put(Direction.UP, Sprites.KEY_MOVE_NORTH);
        moveSpritesMap.put(Direction.DOWN, Sprites.KEY_MOVE_SOUTH);

        standSpritesMap.put(Direction.LEFT, Sprites.KEY_STAND_WEST);
        standSpritesMap.put(Direction.RIGHT, Sprites.KEY_STAND_EAST);
        standSpritesMap.put(Direction.UP, Sprites.KEY_STAND_NORTH);
        standSpritesMap.put(Direction.DOWN, Sprites.KEY_STAND_SOUTH);

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
