package org.ionull.sorrowland.core.container;

import org.ionull.sorrowland.core.common.Initializable;

import java.util.HashMap;

abstract public class AbstractObjectContainer<C> extends HashMap<String, C> implements ObjectContainerInterface<C> {

  @Override
  public C getObject(String name) {
    return get(name);
  }

  @Override
  public void setObject(String name, C object) {
    put(name, object);
  }

  @Override
  public boolean hasObject(String name) {
    return containsKey(name);
  }

}
