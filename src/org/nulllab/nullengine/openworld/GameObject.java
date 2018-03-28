package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.geometry.Collidable;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.state.ObjectState;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D implements Renderable<Canvas>, Updateable, Collidable {

  protected Input          input;
  protected boolean        active;
  protected int            layerID;
  protected ObjectState    state;
  protected ServiceLocator services;
  protected Sprite         sprite;

  public GameObject() {
    // stub mapping
    this(0, 0, 1 << 4, 1 << 4);
  }

  public GameObject(int x, int y, int width, int height) {
    super(x, y, width, height);
    layerID = 1;
    services = ServiceLocator.getInstance();
    input = services.getInputKeyboard();
  }

  public Sprite getSprite() {
    return sprite;
  }

  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }

  public ObjectState getState() {
    return state;
  }

  public void setState(ObjectState state) {
    this.state = state;
  }

  public Input getInput() {
    return input;
  }

  public void setInput(Input input) {
    this.input = input;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void layerDown() {
    layerID >>= 1;
  }

  public void layerUp() {
    layerID <<= 1;
  }

  public int getLayerID() {
    return layerID;
  }

  public void setLayerID(int layerID) {
    this.layerID = layerID;
  }

  @Override
  public void render(Canvas canvas) {
  }

  @Override
  @SuppressWarnings("unchecked")
  public void update(float nano) {
    ObjectState state = this.state.handle(this, input);

    if (state != null) {
      this.state.exitAction(this);
      setState(state);
      this.state.entryAction(this);
    }

    this.state.update(this);
  }

  @Override
  public void collide() {
  }

}
