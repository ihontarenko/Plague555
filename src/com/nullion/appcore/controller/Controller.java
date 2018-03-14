package com.nullion.appcore.controller;

import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.container.ServiceLocator;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.service.AppContextAware;
import com.nullion.appcore.state.AbstractState;
import com.nullion.appcore.state.ProcessMode;
import com.nullion.appcore.view.AbstractView;

import java.awt.*;

abstract public class Controller<S extends AbstractState, V extends AbstractView> implements ControllerInterface, Initializable, AppContextAware {

  private AppContext        context;
  private S                 state;
  private ServiceLocator<V> views;
  private V                 activeView;
  private ProcessMode       processMode;
  private boolean           isInitialized;
  private boolean           isPaused;
  private int               priority;

  public Controller(AppContext context, S state) {
    this.context = context;
    this.views = new ServiceLocator<>();
    this.state = state;
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

  public ServiceLocator<V> getViews() {
    return views;
  }

  public S getState() {
    return state;
  }

  @Override
  public int compareTo(Object controller) {
    return (controller instanceof Controller) ? ((Controller) controller).getPriority() - this.getPriority() : 0;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public void render(Graphics2D g2d) {
    switch (getProcessMode()) {
      case BATCH:
        getViews().forEach((s, controller) -> controller.render(g2d));
        break;
      case ACTIVE:
        getActiveView().render(g2d);
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
  public AppContext getContext() {
    return context;
  }

}
