package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.object.component.bounds.Bounds;
import org.nulllab.nullengine.openworld.object.component.bounds.BoundsInterface;
import org.nulllab.nullengine.openworld.object.component.collision.CollisionDetection;
import org.nulllab.nullengine.openworld.object.component.collision.CollisionDetectionInterface;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;
import org.nulllab.nullengine.openworld.object.component.graphics.GraphicsInterface;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D
    implements Renderable<Canvas>, Updateable, Comparable<GameObject> {

  private boolean                     isSolid;
  private boolean                     isMovable;
  private int                         priority;
  private ServiceLocator              serviceLocator;
  private GameObjectUtils             objectUtils;
  private GraphicsInterface           graphics;
  private BoundsInterface             bounds;
  private CollisionDetectionInterface collisionDetection;

  public GameObject() {
    this(0, 0, 32, 32, null);
  }

  public GameObject(int x, int y, int width, int height, Bounds2D bounds) {
    super(x, y, width, height);

    this.serviceLocator = ServiceLocator.getInstance();
    this.priority = 1;

    setGraphics(new Graphics());
    setBounds(new Bounds());
    setCollisionDetection(new CollisionDetection());
  }

  public GameObject(int x, int y, int width, int height) {
    this(x, y, width, height, null);
  }

  public ServiceLocator getServiceLocator() {
    return serviceLocator;
  }

  public void setPositionTo(double x, double y) {
    setX(x);
    setY(y);
  }

  public boolean isMovable() {
    return isMovable;
  }

  public void setMovable(boolean isMovable) {
    this.isMovable = isMovable;
  }

  public boolean isStatic() {
    return !isMovable();
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

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public GraphicsInterface getGraphics() {
    return graphics;
  }

  public void setGraphics(Graphics graphics) {
    graphics.setGameObject(this);
    this.graphics = graphics;
  }

  public BoundsInterface getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    bounds.setGameObject(this);
    this.bounds = bounds;
  }

  public CollisionDetectionInterface getCollisionDetection() {
    return collisionDetection;
  }

  public void setCollisionDetection(CollisionDetection collisionDetection) {
    collisionDetection.setGameObject(this);
    this.collisionDetection = collisionDetection;
  }

  @Override
  public int compareTo(GameObject object) {
    return this.getPriority() - object.getPriority();
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
