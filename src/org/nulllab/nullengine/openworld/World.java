package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;

import java.util.Set;
import java.util.stream.Stream;

public class World implements Renderable<Canvas>, Updateable {

  private Set<GameObject> gameObjects;
  private SpatialHash     spatialHash;

  public Set<GameObject> getGameObjects() {
    return gameObjects;
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

}
