package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.character.Values;
import org.nulllab.nullengine.openworld.object.component.bounds.Bounds;
import org.nulllab.nullengine.openworld.object.component.bounds.BoundsInterface;
import org.nulllab.nullengine.openworld.object.component.collision.Collision;
import org.nulllab.nullengine.openworld.object.component.collision.CollisionInterface;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;
import org.nulllab.nullengine.openworld.object.component.graphics.GraphicsInterface;
import org.nulllab.nullengine.openworld.object.component.physics.Physics;
import org.nulllab.nullengine.openworld.object.component.physics.PhysicsInterface;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D implements Renderable<Canvas>, Updateable, Comparable<GameObject> {

  private boolean            isSolid;
  private boolean            isMovable;
  private int                priority;
  private Values             values;
  private ServiceLocator     serviceLocator;
  private ObjectHelper       objectUtils;
  private GraphicsInterface  graphics;
  private BoundsInterface    bounds;
  private CollisionInterface collision;
  private PhysicsInterface   physics;

  public GameObject() {
    this(0, 0, 32, 32, null);
  }

  public GameObject(int x, int y, int width, int height, Bounds2D bounds) {
    super(x, y, width, height);

    this.values = new Values();
    this.serviceLocator = ServiceLocator.getInstance();
    this.priority = 1;

    setGraphics(new Graphics());
    setBounds(new Bounds());
    setCollision(new Collision());
    setPhysics(new Physics());
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

  public BoundsInterface getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    bounds.setGameObject(this);
    this.bounds = bounds;
  }

  public CollisionInterface getCollision() {
    return collision;
  }

  public void setCollision(Collision collision) {
    collision.setGameObject(this);
    this.collision = collision;
  }

  public PhysicsInterface getPhysics() {
    return physics;
  }

  public void setPhysics(Physics physics) {
    physics.setGameObject(this);
    this.physics = physics;
  }

  public GraphicsInterface getGraphics() {
    return graphics;
  }

  public void setGraphics(Graphics graphics) {
    graphics.setGameObject(this);
    this.graphics = graphics;
  }

  public ObjectHelper getObjectUtils() {
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
    getGraphics().getSprite().draw(canvas, getX(), getY());
  }



  @Override
  public void update(float nano) {
    // null object ...
  }

}
