package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.state.ObjectState;
import org.nulllab.nullengine.openworld.state.IdleState;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D implements Renderable<Canvas>, Updateable {

  private boolean        active;
  private int            layerIndex;
  private ObjectState    state;
  private ServiceLocator serviceLocator;

  public GameObject() {
    // stub mapping
    this(0, 0, 1 << 4, 1 << 4);
  }

  public GameObject(int x, int y, int width, int height) {
    super(x, y, width, height);
    serviceLocator = ServiceLocator.getInstance();
    state = new IdleState();
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public ObjectState getState() {
    return state;
  }

  public void setState(ObjectState state) {
    this.state = state;
  }

  @Override
  public void render(Canvas canvas) {
    state.render(canvas);
  }

  @Override
  public void update(float nano) {
    ObjectState state = this.state.handle(this, serviceLocator.getInputKeyboard());

    if (state != null) {
      this.state.exitAction(this);
      setState(state);
      this.state.entryAction(this);
    }

    this.state.update(nano);
  }

}
