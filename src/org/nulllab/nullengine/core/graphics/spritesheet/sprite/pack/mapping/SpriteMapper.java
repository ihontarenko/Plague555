package org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping;

abstract public class SpriteMapper {

  private String                  name;
  private double                  scale;
  private int                     colorRemove;

  public SpriteMapper(String name, double scale, int color) {
    this.name = name;
    this.scale = scale;
    this.colorRemove = color;
  }

  public String getName() {
    return name;
  }

  public double getScale() {
    return scale;
  }

  public int getColorRemove() {
    return colorRemove;
  }

}
