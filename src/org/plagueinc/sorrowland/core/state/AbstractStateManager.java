package org.plagueinc.sorrowland.core.state;

import org.plagueinc.sorrowland.core.common.Drawable;
import org.plagueinc.sorrowland.core.common.Initializable;
import org.plagueinc.sorrowland.core.common.Updateable;
import org.plagueinc.sorrowland.core.container.ObjectContainer;

import java.awt.*;

abstract public class AbstractStateManager<State extends AbstractState> implements Drawable, Updateable, Initializable {

  protected boolean                isInitialized;
  private   ObjectContainer<State> states;
  private   State                  activeState;
  private   ProcessMode            processMode;

  public AbstractStateManager() {
    states = new ObjectContainer<>();
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

  abstract protected void doInitialize();

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public State getActiveState() {
    return activeState;
  }

  public void setActiveState(String name) {
    setActiveState(getState(name));
  }

  public void setActiveState(State activeState) {
    this.activeState = activeState;
  }

  public State getState(String name) {
    return states.getObject(name);
  }

  public void registerState(String name, State state) {
    states.setObject(name, state);
  }

  public ObjectContainer<State> getStates() {
    return states;
  }

  @Override
  public void draw(Graphics2D g2d) {
    switch (getProcessMode()) {
      case BATCH:
        getStates().forEach((keyName, state) -> state.draw(g2d));
        break;
      case ACTIVE:
        getActiveState().draw(g2d);
        break;
    }

  }

  @Override
  public void update(float nano) {
    switch (getProcessMode()) {
      case BATCH:
        states.forEach((keyName, state) -> state.update(nano));
        break;
      case ACTIVE:
        getActiveState().update(nano);
        break;
    }
  }

}
