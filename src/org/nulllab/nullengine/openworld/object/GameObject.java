package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bound2D;
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
  private int            layer;
  private Sprite         sprite;
  private Sprites        spritePackage;
  private Bound2D        areaBound;
  private Bound2D        selfBound;
  private ServiceLocator serviceLocator;

  public GameObject() {
    this(0, 0, 1 << 4, 1 << 4);
  }

  public GameObject(int x, int y, int width, int height) {
    super(x, y, width, height);

    layer = 1;
    serviceLocator = ServiceLocator.getInstance();

    setSelfBound(new Bound2D(x, y, width, height));
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
    layer >>= 1;
  }

  public void layerUp() {
    layer <<= 1;
  }

  public int getLayer() {
    return layer;
  }

  public void setLayer(int layer) {
    this.layer = layer;
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

  public ServiceLocator getServiceLocator() {
    return serviceLocator;
  }

  public Bound2D getAreaBound() {
    return areaBound;
  }

  public void setAreaBound(Bound2D areaBound) {
    this.areaBound = areaBound;
  }

  public Bound2D getSelfBound() {
    return selfBound;
  }

  public void setSelfBound(Bound2D selfBound) {
    this.selfBound = selfBound;
  }

  @Override
  public void setX(double x) {
    super.setX(x);
    selfBound.setX(x);
  }

  @Override
  public void setY(double y) {
    super.setY(y);
    selfBound.setY(y);
  }

  @Override
  public int compareTo(GameObject object) {
    return this.getLayer() - object.getLayer();
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
