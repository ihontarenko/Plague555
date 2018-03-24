package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.AbstractServiceLocator;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;

public class ServiceLocator extends AbstractServiceLocator {

  public static ServiceLocator getInstance() {
    return Holder.INSTANCE;
  }

  public SpriteManager getSpriteManager() {
    return getService(SpriteManager.class);
  }

  public World getWorld() {
    return getService(World.class);
  }

  public static class Holder {
    final static ServiceLocator INSTANCE = new ServiceLocator();
  }

}
