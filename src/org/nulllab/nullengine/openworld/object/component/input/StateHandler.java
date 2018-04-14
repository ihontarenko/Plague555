package org.nulllab.nullengine.openworld.object.component.input;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.state.NullState;
import org.nulllab.nullengine.openworld.object.state.ObjectState;

abstract public class StateHandler extends Component implements Updateable {

  protected ObjectState state;

  public StateHandler(GameObject object) {
    super(object);
    this.state = new NullState();
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
      getState().exitAction(getGameObject(), getInput());
      setState(state);
      getState().entryAction(getGameObject(), getInput());
    }

    getState().update(getGameObject(), getInput());
  }

  abstract public Input getInput();

}
