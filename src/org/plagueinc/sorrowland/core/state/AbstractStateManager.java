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

  public AbstractStateManager() {
    states = new ObjectContainer<>();
    initialize();
  }

  public State getActiveState() {
    return activeState;
  }

  public void setActiveState(State activeState) {
    this.activeState = activeState;
  }

  public void setActiveState(String name) {
    setActiveState(getState(name));
  }

  public void registerState(String name, State state) {
    states.setObject(name, state);
  }

  public State getState(String name) {
    return states.getObject(name);
  }

  public ObjectContainer<State> getStates() {
    return states;
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      doInitialize();
    }
  }

  @Override
  public void draw(Graphics2D g2d) {
    states.forEach((keyName, state) -> state.draw(g2d));
  }

  @Override
  public void update(float nanoSeconds) {
    states.forEach((keyName, state) -> state.update(nanoSeconds));
  }

  abstract protected void doInitialize();

}
