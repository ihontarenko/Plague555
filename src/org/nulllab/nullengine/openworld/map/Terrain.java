package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.openworld.object.StaticGameObject;

public class Terrain extends StaticGameObject {

  public Terrain(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public void setSprite(String id) {
    SpriteManager spriteManager = getServiceLocator().getSpriteManager();
    setSprite(spriteManager.getSpriteFromPackage(id));
  }

}
