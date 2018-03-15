package org.nullapp.appCore.process;

import org.nullapp.appCore.common.Initializable;
import org.nullapp.appCore.common.Renderable;
import org.nullapp.appCore.common.Updateable;
import org.nullapp.appCore.container.ServiceLocator;
import org.nullapp.appCore.process.controller.Controller;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.appCore.service.AppContextAware;

import java.awt.*;

abstract public class ControllerManager<C extends Controller>
    implements Renderable, Updateable, Initializable, AppContextAware {

  private boolean           isInitialized;
  private ServiceLocator<C> controllers;
  private C                 activeController;
  private ProcessMode       processMode;
  private AppContext        context;

  public ControllerManager(AppContext context) {
    this.context = context;
    this.controllers = new ServiceLocator<>();
    initialize();
  }

  abstract protected void doInitialize();

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public void registerController(String name, C controller) {
    controllers.setObject(name, controller);
  }

  public void registerController(String name, Class clazz, Object... arguments) {
    controllers.registerService(name, clazz, arguments);
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
