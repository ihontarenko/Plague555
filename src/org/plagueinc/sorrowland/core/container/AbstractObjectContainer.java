package org.plagueinc.sorrowland.core.container;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractObjectContainer<C> extends HashMap<String, C> implements ObjectContainerInterface<C> {

  @Override
  public C getObject(String name) {
    return get(name);
  }

  @Override
  public void setObject(String name, C object) {
    put(name, object);
  }

}
