package org.plagueinc.sorrowland.core.container;

public interface ObjectContainerInterface<C> {

  public C getObject(Class<? extends C> clazz);

}
