package org.plagueinc.sorrowland.core.state;

import org.plagueinc.sorrowland.core.common.Initializable;
import org.plagueinc.sorrowland.core.common.RunnableProcess;
import org.plagueinc.sorrowland.core.container.ObjectContainer;
import org.plagueinc.sorrowland.core.controller.AbstractController;

import java.awt.*;

abstract public class AbstractState<Manager extends AbstractStateManager, Controller extends AbstractController>
    implements RunnableProcess<Controller>, Initializable {

  private ObjectContainer<Controller> controllers;
  private Manager                     stateManager;
  private Controller                  activeController;
  private ProcessMode                 processMode;
  private boolean                     isInitialized;

  public AbstractState(Manager stateManager) {
    this.controllers = new ObjectContainer<>();
    this.stateManager = stateManager;
    initialize();
  }

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public Controller getActiveController() {
    return activeController;
  }

  public void setActiveController(String name) {
    setActiveController(getController(name));
  }

  public void setActiveController(Controller controller) {
    activeController = controller;
  }

  public void registerController(String name, Controller controller) {
    controllers.setObject(name, controller);
  }

  public Controller getController(String name) {
    return controllers.getObject(name);
  }

  public ObjectContainer<Controller> getControllers() {
    return controllers;
  }

  public Manager getStateManager() {
    return stateManager;
  }

  @Override
  public int compareTo(Controller controller) {
    return 0;
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

  abstract protected void doInitialize();

}
