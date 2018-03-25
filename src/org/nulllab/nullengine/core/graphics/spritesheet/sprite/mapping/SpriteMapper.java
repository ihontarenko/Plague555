package org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;

abstract public class SpriteMapper {

  private String                  name;
  private Class<? extends Sprite> spriteClass;
  private double                  scale;
  private int                     colorRemove;

  public SpriteMapper(Class<? extends Sprite> spriteClass, String name, double scale, int color) {
    this.spriteClass = spriteClass;
    this.name = name;
    this.scale = scale;
    this.colorRemove = color;
  }

  public String getName() {
    return name;
  }

  public Class<? extends Sprite> getSpriteClass() {
    return spriteClass;
  }

  public double getScale() {
    return scale;
  }

  public int getColorRemove() {
    return colorRemove;
  }

}
