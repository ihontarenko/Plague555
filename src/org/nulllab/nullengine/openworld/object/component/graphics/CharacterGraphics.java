package org.nulllab.nullengine.openworld.object.component.graphics;

import org.nulllab.nullengine.openworld.object.Direction;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.ObjectHelper;

import java.util.Map;

public class CharacterGraphics extends Graphics {

  private Map<Direction, String> spritesMoveMap;
  private Map<Direction, String> spritesStandMap;

  public CharacterGraphics(GameObject object) {
    super(object);

    ObjectHelper.KeyMap keyMap = getServiceLocator().getObjectHelper().getDirectionMaps();

    spritesStandMap = keyMap.getSpritesMapDirectionOnStand();
    spritesMoveMap  = keyMap.getSpritesMapDirectionOnMove();
  }

  public void setMoveDirectionSprite(Direction direction) {
    setSprite(getObjectSprites().getSprite(spritesMoveMap.get(direction)));
  }

  public void setStandDirectionSprite(Direction direction) {
    setSprite(getObjectSprites().getSprite(spritesStandMap.get(direction)));
  }

}
