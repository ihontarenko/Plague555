package org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping;

public class SpriteStaticMapper extends SpriteMapper {

  private int position;

  public SpriteStaticMapper(String name, double scale, int position) {
    this(name, scale, position, -1);
  }

  public SpriteStaticMapper(String name, double scale, int position, int color) {
    super(name, scale, color);

    this.position = position;
  }

  public int getPosition() {
    return position;
  }

}
