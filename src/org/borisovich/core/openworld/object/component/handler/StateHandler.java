package org.borisovich.core.openworld.object.component.handler;

import org.borisovich.core.core.input.Input;
import org.borisovich.core.core.loop.Updateable;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.component.Component;
import org.borisovich.core.openworld.object.state.NullState;
import org.borisovich.core.openworld.object.state.ObjectState;

abstract public class StateHandler extends Component implements Updateable {

  private ObjectState state;
  private Input input;

  public StateHandler(GameObject object, Input input) {
    super(object);
    this.state = new NullState();
    this.input = input;
  }

  public ObjectState getState() {
    return state;
  }

  public void setState(ObjectState state) {
    this.state = state;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void update(float nano) {
    ObjectState state = getState().handle(getGameObject(), getInput());

    if (state != null) {
      swapState(state);
    }

    getState().update(getGameObject(), getInput());
  }

  @SuppressWarnings("unchecked")
  private void swapState(ObjectState state) {
    getState().exitAction(getGameObject(), getInput());
    setState(state);
    getState().entryAction(getGameObject(), getInput());
  }

  public Input getInput() {
    return input;
  }

  public void setInput(Input input) {
    this.input = input;
  }

}
