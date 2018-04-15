package org.nulllab.nullengine.openworld.object.component.handler;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.state.NullState;
import org.nulllab.nullengine.openworld.object.state.ObjectState;

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
