package org.borisovich.core.openworld;

import org.borisovich.core.core.AbstractServiceLocator;
import org.borisovich.core.core.audio.AudioManager;
import org.borisovich.core.core.graphics.spritesheet.SpriteManager;
import org.borisovich.core.core.input.Input;
import org.borisovich.core.core.input.Keyboard;
import org.borisovich.core.openworld.object.ObjectHelper;
import org.borisovich.core.openworld.object.collision.CollisionDetector;

public class ServiceLocator extends AbstractServiceLocator {

  public static ServiceLocator getInstance() {
    return Holder.INSTANCE;
  }

  public SpriteManager getSpriteManager() {
    return getService(SpriteManager.class);
  }

  public AudioManager getAudioManager() {
    return getService(AudioManager.class);
  }

  public World getWorld() {
    return getService(World.class);
  }

  public Input getInputKeyboard() {
    return getService(Keyboard.class);
  }

  public ObjectHelper getObjectHelper() {
    return getService(ObjectHelper.class);
  }

  public CollisionDetector getCollisionDetector() {
    return getService(CollisionDetector.class);
  }

  public static class Holder {
    final static ServiceLocator INSTANCE = new ServiceLocator();
  }

}
