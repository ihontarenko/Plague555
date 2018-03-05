package org.plagueinc.sorrowland.core.container;

public interface ObjectContainerInterface<C> {

  public C getObject(String name);

  public void setObject(String name, C object);

}
