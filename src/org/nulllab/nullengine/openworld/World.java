package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.geometry.Collidable;
import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.map.WorldMap;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.world.Camera;

import java.util.*;

public class World implements Renderable<Canvas>, Updateable, Collidable, Initializable {

  private Set<GameObject>         gameObjects;
  private SpatialHash<GameObject> spatialHash;
  private Camera                  camera;
  private WorldMap                worldMap;

  public World() {
    WorldMap worldMap = new WorldMap(this);
    Camera   camera   = new Camera(0, 0, 800, 640);

    camera.setBound2D(worldMap.getBound());

    this.gameObjects = new TreeSet<>();
    this.spatialHash = new SpatialHash<>(worldMap.getBound(), 4);

    this.camera = camera;
    this.worldMap = worldMap;
  }

  public void addGameObject(GameObject object) {
    gameObjects.add(object);
    spatialHash.insert(object);
  }

  public void removeGameObject(GameObject object) {
    gameObjects.remove(object);
    spatialHash.remove(object);
  }

  public SpatialHash getSpatialHash() {
    return spatialHash;
  }

  public Camera getCamera() {
    return camera;
  }

  public WorldMap getWorldMap() {
    return worldMap;
  }

  @Override
  public void render(Canvas canvas) {
    List<GameObject> objects = new ArrayList<>(spatialHash.retrieve(camera));

    Collections.sort(objects);

    objects.forEach(gameObject ->
        gameObject.getSprite().draw(canvas,
            gameObject.getX() - camera.getX(), gameObject.getY() - camera.getY()));

    canvas.drawRectangle(0, 0, camera.getWidth(), camera.getHeight());
  }

  @Override
  public void update(float nano) {
    getGameObjects().forEach(object -> object.update(nano));

    getGameObjects().stream().filter(GameObject::isMovable).forEach(object -> spatialHash.reinsert(object));
  }

  public Set<GameObject> getGameObjects() {
    return gameObjects;
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
    worldMap.buildMap();
  }

  @Override
  public void reinitialize() {

  }
}
