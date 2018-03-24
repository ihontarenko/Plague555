package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.component.Component;
import org.nulllab.nullengine.component.ComponentCollection;
import org.nulllab.nullengine.core.ServiceLocator;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.state.GameObjectState;
import org.nulllab.nullengine.openworld.state.NullState;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D implements Renderable<Canvas>, Updateable {

  private boolean             active;
  private ComponentCollection components;
  private GameObjectState     objectState;
  private ServiceLocator      serviceLocator;

  public GameObject() {
    // stub mapping
    this(0, 0, 1 << 4, 1 << 4);
  }

  public GameObject(int x, int y, int width, int height) {
    super(x, y, width, height);
    serviceLocator = ServiceLocator.getInstance();
    components = new ComponentCollection();
    objectState = new NullState();
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
    objectState.render(canvas);
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
