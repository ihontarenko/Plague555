package org.nulllab.nullengine.core;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;

public class ServiceLocator extends AbstractServiceLocator {

  public static class Holder {
    final static ServiceLocator INSTANCE = new ServiceLocator();
  }

  public static ServiceLocator getInstance() {
    return Holder.INSTANCE;
  }

  public SpriteManager getSpriteManager() {
    return getService(SpriteManager.class);
  }

}
