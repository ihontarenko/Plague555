package org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteStatic;

public class SpriteStaticMapper extends SpriteMapper {

  private int position;

  public SpriteStaticMapper(String name, double scale, int position) {
    this(name, scale, position, -1);
  }

  public SpriteStaticMapper(String name, double scale, int position, int color) {
    super(SpriteStatic.class, name, scale, color);

    this.position = position;
  }

  public int getPosition() {
    return position;
  }

}
