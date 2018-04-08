package org.nulllab.nullengine.openworld.object;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.character.Sprites;

import java.util.List;

@SuppressWarnings("unused")
abstract public class GameObject extends Object2D
    implements Renderable<Canvas>, Updateable, Comparable<GameObject> {

  private boolean         isSolid;
  private boolean         isMovable;
  private int             priority;
  private Sprite          sprite;
  private Sprites         objectSprites;
  private ServiceLocator  serviceLocator;
  private Bounds2D        outerBounds;
  private GameObjectUtils objectUtils;

  public GameObject() {
    this(0, 0, 32, 32, null);
  }

  public GameObject(int x, int y, int width, int height, Bounds2D bounds) {
    super(x, y, width, height);

    ServiceLocator serviceLocator = ServiceLocator.getInstance();

    this.serviceLocator = serviceLocator;
    this.outerBounds = bounds;
    this.priority = 1;
    this.objectUtils = serviceLocator.getGameObjectUtils();
  }

  public GameObject(int x, int y, int width, int height) {
    this(x, y, width, height, null);
  }

  public void setPositionTo(double x, double y) {
    setX(x);
    setY(y);
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

  public Sprites getObjectSprites() {
    return objectSprites;
  }

  public void setObjectSprites(Sprites objectSprites) {
    this.objectSprites = objectSprites;
  }

  public Sprite getSprite() {
    return sprite;
  }

  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }

  public void setSpriteFromPackage(String id) {
    SpriteManager spriteManager = getServiceLocator().getSpriteManager();
    List<String>  idParts       = SpriteManager.getIDParts(id);
    SpritePackage spritePackage = spriteManager.getSpritePackage(idParts.get(0));

    setSprite(spritePackage.getSprite(idParts.get(1)));
  }

  public Bounds2D getOuterBounds() {
    return outerBounds;
  }

  public Bounds2D getInnerBound() {
    return new Bounds2D(getX(), getY(), getWidth(), getHeight());
  }

  public Bounds2D getSpatialBounds() {
    return new Bounds2D(getX() - 10, getY() - 10, getWidth() + 20, getHeight() + 20);
  }

  public void setOuterBounds(Bounds2D bounds) {
    this.outerBounds = bounds;
  }

  public ServiceLocator getServiceLocator() {
    return serviceLocator;
  }

  public GameObjectUtils getObjectUtils() {
    return objectUtils;
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
  public void update(float nano) {
    // null object ...
  }

}
