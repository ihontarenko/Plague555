package org.nulllab.nullengine.openworld.object.component;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.object.GameObject;

abstract public class Component implements Initializable {

  protected GameObject object;

  public GameObject getGameObject() {
    return object;
  }

  public void setGameObject(GameObject object) {
    this.object = object;
  }

  public ServiceLocator getServiceLocator() {
    return ServiceLocator.getInstance();
  }

  @Override
  public boolean isInitialized() {
    return object != null;
  }

  @Override
  public void initialize() {
    // do nothing
  }

  @Override
  public void reinitialize() {
    // do nothing
  }
}
