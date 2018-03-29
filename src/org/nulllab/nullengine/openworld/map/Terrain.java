package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.sorrowland.app.graphics.sprite.WorldMapTilesSprites;

public class Terrain extends GameObject {

  private Type type;

  public Terrain(Type type) {
    this();
    this.type = type;

    setSprite(this.getServiceLocator().getSpriteManager().getSpriteFromPackage(WorldMapTilesSprites.class, "grass"));
  }

  public Terrain() {
  }

  public Type getType() {
    return type;
  }

  @Override
  public void collide() {

  }

  @Override
  public void update(float nano) {

  }

  public enum Type {
    WATER,
    SAND,
    GRASS
  }

}
