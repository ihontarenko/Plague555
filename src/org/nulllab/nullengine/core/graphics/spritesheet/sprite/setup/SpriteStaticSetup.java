package org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteStatic;

public class SpriteStaticSetup extends SpriteSetup {

  private int position;

  public SpriteStaticSetup(String name, int scale, int position) {
    super(SpriteStatic.class, name, scale);
  }

  public int getPosition() {
    return position;
  }

}
