package org.nulllab.nullengine.openworld.object.component;

import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.object.GameObject;

abstract public class Component implements ComponentInterface {

  protected GameObject object;

  public Component(GameObject object) {
    this.object = object;
  }

  @Override
  public GameObject getGameObject() {
    return object;
  }

  @Override
  public void setGameObject(GameObject object) {
    this.object = object;
  }

  protected ServiceLocator getServiceLocator() {
    return ServiceLocator.getInstance();
  }
}
