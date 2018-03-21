package org.nulllab.nullengine.game.object;

import org.nulllab.nullengine.component.Component;
import org.nulllab.nullengine.component.ComponentCollection;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.game.state.GameObjectState;

@SuppressWarnings("unused")
abstract public class GameObject implements Renderable<Canvas>, Updateable {

  private boolean             active;
  private ComponentCollection components;
  private GameObjectState     objectState;

  public GameObject() {
    components = new ComponentCollection();
  }

  public Component getComponent(String name) {
    return components.getObject(name);
  }

  public void setComponent(String name, Component component) {
    components.setObject(name, component);
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public GameObjectState getObjectState() {
    return objectState;
  }

  public void setObjectState(GameObjectState objectState) {
    this.objectState = objectState;
  }

  @Override
  public void render(Canvas canvas) {

  }

  @Override
  public void update(float nano) {
    GameObjectState state = objectState.handle(this, new Keyboard());

    if (state != null) {
      setObjectState(state);
    }

    objectState.update(nano);
  }

}
