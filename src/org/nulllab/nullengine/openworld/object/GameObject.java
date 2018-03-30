package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Collidable;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.character.Sprites;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D
    implements Renderable<Canvas>, Updateable, Collidable, Comparable<GameObject> {

  private boolean        isSolid;
  private boolean        isStatic;
  private Sprite         sprite;
  private Sprites        spritePackage;
  private int            layerID;
  private ServiceLocator serviceLocator;

  public GameObject() {
    this(0, 0, 1 << 4, 1 << 4);
  }

  public GameObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    layerID = 1;
    serviceLocator = ServiceLocator.getInstance();
  }

  public boolean isStatic() {
    return isStatic;
  }

  public boolean isMovable() {
    return !isStatic();
  }

  public void setStatic(boolean isStatic) {
    this.isStatic = isStatic;
  }

  public boolean isSolid() {
    return isSolid;
  }

  public void setSolid(boolean solid) {
    isSolid = solid;
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

  public Sprites getSpritePackage() {
    return spritePackage;
  }

  public void setSpritePackage(Sprites spritePackage) {
    this.spritePackage = spritePackage;
  }

  public ServiceLocator getServiceLocator() {
    return serviceLocator;
  }

  @Override
  public int compareTo(GameObject object) {
    return this.getLayerID() - object.getLayerID();
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

  public Sprite getSprite() {
    return sprite;
  }

  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }

}
