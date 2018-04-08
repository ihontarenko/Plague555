package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.AbstractServiceLocator;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.openworld.object.GameObjectUtils;

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

  public Input getInputKeyboard() {
    return getService(Keyboard.class);
  }

  public GameObjectUtils getGameObjectUtils() {
    return getService(GameObjectUtils.class);
  }

  public static class Holder {
    final static ServiceLocator INSTANCE = new ServiceLocator();
  }

}
