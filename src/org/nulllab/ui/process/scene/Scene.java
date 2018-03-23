package org.nulllab.ui.process.scene;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.container.ObjectManager;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.ui.service.Context;
import org.nulllab.ui.service.ContextAware;
import org.nulllab.ui.process.ProcessMode;
import org.nulllab.ui.process.view.AbstractView;

abstract public class Scene<V extends AbstractView> implements SceneInterface, Initializable, ContextAware {

  private Context          context;
  private ObjectManager<V> views;
  private V                activeView;
  private ProcessMode      processMode;
  private boolean          isInitialized;
  private boolean          isPaused;
  private int              priority;

  public Scene(Context context) {
    this.context = context;
    this.views = new ObjectManager<>();
    initialize();
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      setProcessMode(ProcessMode.ACTIVE);
      doInitialize();
      isInitialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

  abstract protected void doInitialize();

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public void registerView(String name, V v) {
    views.setObject(name, v);
  }

  public void registerView(String name, Class viewClass, Object... arguments) {
    views.registerService(name, viewClass, arguments);
  }

  public V getView(String name) {
    return views.getObject(name);
  }

  public V getActiveView() {
    return activeView;
  }

  public void setActiveView(V activeView) {
    this.activeView = activeView;
  }

  public void setActiveView(String name) {
    setActiveView(getView(name));
  }

  public ObjectManager<V> getViews() {
    return views;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public void render(Canvas canvas) {
    switch (getProcessMode()) {
      case BATCH:
        getViews().forEach((s, controller) -> controller.render(canvas));
        break;
      case ACTIVE:
        getActiveView().render(canvas);
        break;
    }
  }

  @Override
  public void pause() {
    isPaused = true;
  }

  @Override
  public void resume() {
    isPaused = false;
  }

  @Override
  public boolean isPaused() {
    return isPaused;
  }

  @Override
  public void update(float nano) {
    if (!isPaused()) {
      doUpdate(nano);
    }
  }

  public abstract void doUpdate(float nano);

  @Override
  public Context getContext() {
    return context;
  }

}
