package org.plagueinc.sorrowland.core.container;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractObjectContainer<C> implements ObjectContainerInterface<C> {

  private Map<Class<? extends C>, C> instances;

  public AbstractObjectContainer() {
    instances = new HashMap<>();
  }

  @Override
  public C getObject(Class<? extends C> clazz) {
    if (!instances.containsKey(clazz)) {
      try {
        instances.put(clazz, clazz.newInstance());
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }

    return instances.get(clazz);
  }

  public Map<Class<? extends C>, C> getInstances() {
    return instances;
  }

}
