package org.borisovich.core.openworld.object;

import org.borisovich.core.core.event.Observable;
import org.borisovich.core.core.geometry.Bounds2D;
import org.borisovich.core.core.geometry.Object2D;
import org.borisovich.core.core.graphics.Canvas;
import org.borisovich.core.core.graphics.Renderable;
import org.borisovich.core.core.loop.Updateable;
import org.borisovich.core.openworld.ServiceLocator;
import org.borisovich.core.core.values.DoubleValues;
import org.borisovich.core.openworld.object.component.graphics.Graphics;
import org.borisovich.core.openworld.object.component.handler.NullHandler;
import org.borisovich.core.openworld.object.component.handler.StateHandler;
import org.borisovich.core.openworld.object.component.physics.Physics;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D implements Renderable<Canvas>, Updateable, Comparable<GameObject> {

  private boolean                isSolid;
  private boolean                isMovable;
  private int                    priority;
  private DoubleValues           values;
  private ServiceLocator         serviceLocator;
  private ObjectHelper           objectHelper;
  private Observable<GameObject> observable;
  private StateHandler           stateHandler;
  private Graphics               graphics;
  private Physics                physics;

  public GameObject() {
    this(0, 0, 32, 32, null);
  }

  public GameObject(int x, int y, int width, int height, Bounds2D bounds) {
    super(x, y, width, height);

    this.values = new DoubleValues();
    this.serviceLocator = ServiceLocator.getInstance();
    this.priority = 1;

    this.observable = new Observable<>();

    setGraphics(new Graphics(this));
    setPhysics(new Physics(this));
    setStateHandler(new NullHandler(this));
  }

  public GameObject(int x, int y, int width, int height) {
    this(x, y, width, height, null);
  }

  public void setValue(String key, Double value) {
    values.setValue(key, value);
  }

  public Double getValue(String key) {
    return values.getValue(key);
  }

  public boolean isStatic() {
    return !isMovable();
  }

  public boolean isMovable() {
    return isMovable;
  }

  public void setMovable(boolean isMovable) {
    this.isMovable = isMovable;
  }

  public boolean isSolid() {
    return isSolid;
  }

  public void setSolid(boolean solid) {
    isSolid = solid;
  }

  public void layerDown() {
    priority >>= 1;
  }

  public void layerUp() {
    priority <<= 1;
  }

  public Physics getPhysics() {
    return physics;
  }

  public void setPhysics(Physics physics) {
    this.physics = physics;
  }

  public StateHandler getStateHandler() {
    return stateHandler;
  }

  public void setStateHandler(StateHandler stateHandler) {
    this.stateHandler = stateHandler;
  }

  public Observable<GameObject> getObservable() {
    return observable;
  }

  public void setObservable(Observable<GameObject> observable) {
    this.observable = observable;
  }

  public ObjectHelper getObjectHelper() {
    return getServiceLocator().getObjectHelper();
  }

  public ServiceLocator getServiceLocator() {
    return serviceLocator;
  }

  @Override
  public int compareTo(GameObject object) {
    return this.getPriority() - object.getPriority();
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public void render(Canvas canvas) {
    render(canvas, getX(), getY());
  }

  public void render(Canvas canvas, double x, double y) {
    getGraphics().getSprite().draw(canvas, x, y);
  }

  public Graphics getGraphics() {
    return graphics;
  }

  public void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }

  @Override
  public void update(float nano) {
    // null object ...
  }

}
