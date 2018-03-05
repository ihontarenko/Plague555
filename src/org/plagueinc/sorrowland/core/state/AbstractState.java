package org.plagueinc.sorrowland.core.state;

import org.plagueinc.sorrowland.core.common.RunnableProcess;
import org.plagueinc.sorrowland.core.container.ObjectContainer;
import org.plagueinc.sorrowland.core.controller.AbstractController;

import java.awt.*;

abstract public class AbstractState<Manager extends AbstractStateManager, Controller extends AbstractController>
    implements RunnableProcess<Controller> {

  private ObjectContainer<Controller> controllers;
  private Manager                     stateManager;
  private Controller                  activeController;
  private ProcessMode                 processMode;

  public AbstractState() {
    this(null);
  }

  public AbstractState(Manager stateManager) {
    this.controllers = new ObjectContainer<>();
    this.stateManager = stateManager;
    this.processMode = ProcessMode.ACTIVE;
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

  public void setActiveController(Controller controller) {
    activeController = controller;
  }

  public void setActiveController(String name) {
    setActiveController(getController(name));
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
  public void draw(Graphics2D g2d) {
    switch (getProcessMode()) {
      case BATCH:
        getControllers().forEach((s, controller) -> controller.draw(g2d));
      case ACTIVE:
        getActiveController().draw(g2d);
    }
  }

  @Override
  public void update(float nanoSeconds) {
    switch (getProcessMode()) {
      case BATCH:
        getControllers().forEach((s, controller) -> controller.update(nanoSeconds));
      case ACTIVE:
        getActiveController().update(nanoSeconds);
    }
  }

  public enum ProcessMode {
    BATCH, ACTIVE
  }

}
