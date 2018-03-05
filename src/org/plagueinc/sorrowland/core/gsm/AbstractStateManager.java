package org.plagueinc.sorrowland.core.gsm;

import org.plagueinc.sorrowland.core.common.Drawable;
import org.plagueinc.sorrowland.core.common.Updateable;
import org.plagueinc.sorrowland.core.container.ObjectContainer;

import java.awt.*;

abstract public class AbstractStateManager<State extends AbstractState> implements Drawable, Updateable {

  private ObjectContainer<State> states;

  public AbstractStateManager() {
    states = new ObjectContainer<>();
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
  public void draw(Graphics2D g2d) {
    states.forEach((keyName, state) -> state.draw(g2d));
  }

  @Override
  public void update(float nanoSeconds) {
    states.forEach((keyName, state) -> state.update(nanoSeconds));
  }

}
