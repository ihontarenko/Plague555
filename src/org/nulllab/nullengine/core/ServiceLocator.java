package org.nulllab.nullengine.core;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;

public class ServiceLocator extends AbstractServiceLocator {

  private static ServiceLocator instance;

  public static ServiceLocator getInstance() {
    if (null == instance)
      instance = new ServiceLocator();

    return instance;
  }

  public SpriteManager getSpriteManager() {
    return getService(SpriteManager.class);
  }

}
