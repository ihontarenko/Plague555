package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.openworld.object.GameObject;

public class Terrain extends GameObject {

  public Terrain(int x, int y, int width, int height) {
    super(x, y, width, height);

    SpriteManager spriteManager = this.getServiceLocator().getSpriteManager();
    setSprite(spriteManager.getSpriteFromPackage("tiles.grass2"));

    setStatic(true);
  }

}
