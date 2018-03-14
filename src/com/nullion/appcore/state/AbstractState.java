package com.nullion.appcore.state;

import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.common.RunnableProcess;
import com.nullion.appcore.container.ServiceLocator;
import com.nullion.appcore.controller.Controller;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.service.AppContextAware;

import java.awt.*;

abstract public class AbstractState<C extends Controller> implements RunnableProcess, Initializable, AppContextAware {

  private AppContext        context;
  private ServiceLocator<C> controllers;
  private C                 activeController;
  private ProcessMode       processMode;
  private boolean           isInitialized;
  private int               priority;

  public AbstractState(AppContext context) {
    this.context = context;
    this.controllers = new ServiceLocator<>();
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
    getControllers().values().forEach(Controller::reinitialize);
  }

  abstract protected void doInitialize();

  public void registerController(String name, C controller) {
    controllers.setObject(name, controller);
  }

  public void registerController(String name, Class clazz, Object... arguments) {
    controllers.registerService(name, clazz, arguments);
  }

  @Override
  public int compareTo(Object state) {
    return (state instanceof AbstractState) ? ((AbstractState) state).getPriority() - this.getPriority() : 0;
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
        getControllers().forEach((s, controller) -> controller.render(g2d));
        break;
      case ACTIVE:
        getActiveController().render(g2d);
        break;
    }
  }

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public ServiceLocator<C> getControllers() {
    return controllers;
  }

  public C getActiveController() {
    return activeController;
  }

  public void setActiveController(String name) {
    setActiveController(getController(name));
  }

  public void setActiveController(C activeController) {
    this.activeController = activeController;
  }

  public C getController(String name) {
    return controllers.getObject(name);
  }

  @Override
  public void update(float nanoSeconds) {
    switch (getProcessMode()) {
      case BATCH:
        getControllers().forEach((s, controller) -> controller.update(nanoSeconds));
        break;
      case ACTIVE:
        getActiveController().update(nanoSeconds);
        break;
    }
  }

  @Override
  public AppContext getContext() {
    return context;
  }

}
