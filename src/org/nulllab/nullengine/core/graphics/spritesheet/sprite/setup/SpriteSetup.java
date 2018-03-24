package org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;

abstract public class SpriteSetup {

  private String                  name;
  private Class<? extends Sprite> spriteClass;
  private double                  scale;

  public SpriteSetup(Class<? extends Sprite> spriteClass, String name, double scale) {
    this.spriteClass = spriteClass;
    this.name = name;
    this.scale = scale;
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
}
