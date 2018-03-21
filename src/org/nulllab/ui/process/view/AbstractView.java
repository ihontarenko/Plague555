package org.nulllab.ui.process.view;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.ui.service.ContextAware;
import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.container.ServiceLocator;
import org.nulllab.ui.process.scene.Scene;
import org.nulllab.ui.service.Context;

abstract public class AbstractView<S extends Scene, R extends AbstractView>
    implements View<R, ServiceLocator<R>>, Initializable, Comparable<R>, ContextAware {

  private Context           context;
  private ServiceLocator<R> innerViews;
  private S                 controller;
  private R                 parent;
  private boolean           isInitialized;
  private int               priority;

  public AbstractView(Context context, S scene) {
    this.context = context;
    this.controller = scene;
    this.innerViews = new ServiceLocator<>();

    initialize();
  }

  abstract public void doInitialize();

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      doInitialize();
      isInitialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

  @Override
  public int compareTo(R view) {
    return this.getPriority() - view.getPriority();
  }

  @Override
  public R getParent() {
    return parent;
  }

  @Override
  public void setParent(R view) {
    parent = view;
  }

  @Override
  public ServiceLocator<R> getInnerViews() {
    return innerViews;
  }

  @Override
  public R getInnerView(String name) {
    return null;
  }

  @Override
  public void registerInnerView(String name, R view) {
    innerViews.setObject(name, view);
  }

  @Override
  public void render(Canvas canvas) {
    if (getInnerViews().size() > 0) {
      getInnerViews().forEach((s, view) -> view.render(canvas));
    }
  }

  @Override
  public Context getContext() {
    return context;
  }

  public S getController() {
    return controller;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

}
