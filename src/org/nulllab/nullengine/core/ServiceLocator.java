package org.nulllab.nullengine.core;

public class ServiceLocator extends AbstractServiceLocator {

  private static ServiceLocator instance;

  public static ServiceLocator getInstance() {
    if (null == instance)
      instance = new ServiceLocator();

    return instance;
  }

}
