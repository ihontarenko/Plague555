package org.borisovich.plague555.app.graphics.sprite;

import org.borisovich.core.openworld.world.graphics.CharacterSpritesDefaultMapper;

public class PlayerSprites extends CharacterSpritesDefaultMapper {

  public PlayerSprites() {
    super("a03f.c1");
  }

  @Override
  public String getPackageName() {
    return "player";
  }
}
