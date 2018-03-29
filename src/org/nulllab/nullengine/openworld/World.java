package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.core.geometry.Collidable;
import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.loop.Updateable;
import org.nulllab.nullengine.openworld.map.Terrain;
import org.nulllab.nullengine.openworld.map.WorldMap;
import org.nulllab.nullengine.openworld.world.Camera;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class World implements Renderable<Canvas>, Updateable, Collidable, Initializable {

  private Set<GameObject> gameObjects;
  private SpatialHash     spatialHash;
  private Camera          camera;
  private WorldMap        worldMap;

  public World() {
    WorldMap worldMap = new WorldMap(this);
    Camera   camera   = new Camera(0, 0, 600, 400);

    this.gameObjects = new TreeSet<>();
    this.spatialHash = new SpatialHash(new Bound2D(0, 0, worldMap.getWidthInPixels(), worldMap.getHeightInPixels()), 4);

    spatialHash.insert(camera);

    this.camera = camera;
    this.worldMap = worldMap;
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
    canvas.setColor("#0000ff");
    canvas.drawRectangle(0, 0, camera.getWidth(), camera.getHeight());

    canvas.setColor("#ff0000");
    spatialHash.retrieve(camera).forEach(object2D -> {
      if (object2D instanceof Terrain) {
        GameObject gameObject = (GameObject) object2D;
        gameObject.getSprite().draw(canvas, object2D.getX() - camera.getX(), object2D.getY() - camera.getY());
      }
    });
  }

  private Stream<GameObject> getActiveObjects() {
    return gameObjects.stream();
  }

  @Override
  public void update(float nano) {

    camera.setX(camera.getX() + 0.5D);
    camera.setY(camera.getY() + 0.2D);

    spatialHash.reinsert(camera);

    //    getActiveObjects().forEach(gameObject -> gameObject.update(nano));
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
