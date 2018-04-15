package org.nulllab.sorrowland.app.graphics.sprite;

import org.nulllab.nullengine.openworld.world.graphics.CharacterSpritesDefaultMapper;

public class PlayerSprites extends CharacterSpritesDefaultMapper {

  public PlayerSprites() {
    super("a03f.c1");
  }

  @Override
  public String getPackageName() {
    return "player";
  }
}
