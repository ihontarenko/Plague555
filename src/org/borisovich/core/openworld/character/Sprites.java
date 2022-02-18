package org.borisovich.core.openworld.character;

import org.borisovich.core.core.graphics.spritesheet.sprite.Sprite;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.SpritePackage;

abstract public class Sprites extends SpritePackage {

  public static final String KEY_STAND_WEST  = "standWest";
  public static final String KEY_STAND_EAST  = "standEast";
  public static final String KEY_STAND_NORTH = "standNorth";
  public static final String KEY_STAND_SOUTH = "standSouth";
  public static final String KEY_MOVE_WEST   = "moveWest";
  public static final String KEY_MOVE_EAST   = "moveEast";
  public static final String KEY_MOVE_NORTH  = "moveNorth";
  public static final String KEY_MOVE_SOUTH  = "moveSouth";

  public Sprites(String sheetID) {
    super(sheetID);
  }

  public Sprite getMoveNorth() {
    return getSprite(KEY_MOVE_NORTH);
  }

  public Sprite getMoveSouth() {
    return getSprite(KEY_MOVE_SOUTH);
  }

  public Sprite getMoveWest() {
    return getSprite(KEY_MOVE_WEST);
  }

  public Sprite getMoveEast() {
    return getSprite(KEY_MOVE_EAST);
  }

  public Sprite getStandNorth() {
    return getSprite(KEY_STAND_NORTH);
  }

  public Sprite getStandSouth() {
    return getSprite(KEY_STAND_SOUTH);
  }

  public Sprite getStandWest() {
    return getSprite(KEY_STAND_WEST);
  }

  public Sprite getStandEast() {
    return getSprite(KEY_STAND_EAST);
  }

  @Override
  public Sprite getDefaultSprite() {
    return getStandSouth();
  }
}
