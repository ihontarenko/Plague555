package org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteStatic;

public class SpriteStaticMapper extends SpriteMapper {

  private int position;

  public SpriteStaticMapper(String name, int scale, int position) {
    super(SpriteStatic.class, name, scale);

    this.position = position;
  }

  public int getPosition() {
    return position;
  }

}
