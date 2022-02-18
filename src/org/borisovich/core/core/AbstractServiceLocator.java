package org.borisovich.core.core;

import org.borisovich.core.core.container.ObjectManager;

@SuppressWarnings({"unused", "unchecked"})
abstract public class AbstractServiceLocator {

  private ObjectManager<Object> objectManager;

  protected AbstractServiceLocator() {
    this.objectManager = new ObjectManager<>();
  }

  public <T> T getService(String name) {
    return (T) objectManager.getObject(name);
  }

  public <T> T getService(Class<T> clazz) {
    return getService(clazz.getSimpleName());
  }

  public <T> void addService(Class<?> clazz, T service) {
    objectManager.setObject(clazz.getSimpleName(), service);
  }

  public <T> void addService(String keyName, T service) {
    objectManager.setObject(keyName, service);
  }

  public void addService(String keyName, Class<?> clazz, Object... arguments) {
    objectManager.registerService(keyName, clazz, arguments);
  }

  public void addService(String keyName, Class<?> clazz) {
    objectManager.registerService(keyName, clazz);
  }

  public void addService(Class<?> clazz) {
    addService(clazz.getSimpleName(), clazz);
  }

}
