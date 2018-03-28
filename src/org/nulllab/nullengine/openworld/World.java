package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.geometry.Collidable;
import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class World implements Renderable<Canvas>, Updateable, Collidable, Initializable {

  private Set<GameObject> gameObjects;
  private SpatialHash     spatialHash;

  public World() {
    this.gameObjects = new TreeSet<>();
  }

  public Set<GameObject> getGameObjects() {
    return gameObjects;
  }

  public void addGameObject(GameObject object) {
    gameObjects.add(object);
    spatialHash.insert(object);
  }

  public void removeGameObject(GameObject object) {
    gameObjects.remove(object);
    spatialHash.remove(object);
  }

  @Override
  public void render(Canvas g2d) {
    getActiveObjects().forEach(gameObject -> gameObject.render(g2d));
  }

  private Stream<GameObject> getActiveObjects() {
    return gameObjects.stream().filter(GameObject::isActive);
  }

  @Override
  public void update(float nano) {
    getActiveObjects().forEach(gameObject -> gameObject.update(nano));
  }

  @Override
  public void collide() {
    // collision detection here
  }

  @Override
  public boolean isInitialized() {
    return false;
  }

  @Override
  public void initialize() {

  }

  @Override
  public void reinitialize() {

  }
}
