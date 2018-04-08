package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.core.geometry.Collidable;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.character.Sprites;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D
    implements Renderable<Canvas>, Updateable, Collidable, Comparable<GameObject> {

  private boolean        isSolid;
  private boolean        isMovable;
  private int            priority;
  private Sprite         sprite;
  private Sprites        spritePackage;
  private ServiceLocator serviceLocator;
  private Bound2D        bounds;

  public GameObject() {
    this(0, 0, 32, 32, null);
  }

  public GameObject(int x, int y, int width, int height, Bound2D bounds) {
    super(x, y, width, height);

    this.bounds = bounds;
    this.priority = 1;
    this.serviceLocator = ServiceLocator.getInstance();
  }

  public GameObject(int x, int y, int width, int height) {
    this(x, y, width, height, null);
  }

  public boolean isMovable() {
    return isMovable;
  }

  public boolean isStatic() {
    return !isMovable();
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

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public Sprites getSpritePackage() {
    return spritePackage;
  }

  public void setSpritePackage(Sprites spritePackage) {
    this.spritePackage = spritePackage;
  }

  public Sprite getSprite() {
    return sprite;
  }

  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }

  public void setSprite(String id) {
    SpriteManager spriteManager = getServiceLocator().getSpriteManager();
    setSprite(spriteManager.getSpriteFromPackage(id));
  }

  public Bound2D getBounds() {
    return bounds;
  }

  public void setBounds(Bound2D bounds) {
    this.bounds = bounds;
  }

  public ServiceLocator getServiceLocator() {
    return serviceLocator;
  }

  @Override
  public int compareTo(GameObject object) {
    return this.getPriority() - object.getPriority();
  }

  @Override
  public void render(Canvas canvas) {
    getSprite().draw(canvas, getX(), getY());
  }

  @Override
  public void collide() {
    // null object ...
  }

  @Override
  public void update(float nano) {
    // null object ...
  }

}
