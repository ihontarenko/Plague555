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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class World implements Renderable<Canvas>, Updateable, Collidable, Initializable {

  private SpatialHash<GameObject> spatialHash;
  private Camera                  camera;
  private WorldMap                worldMap;
  private boolean                 initialized;

  public World() {
    WorldMap worldMap = new WorldMap("map/World1.map");
    Camera   camera   = new Camera(0, 0, 800, 640);

    worldMap.initialize();
    camera.setAreaBound(worldMap.getBound());

    this.spatialHash = new SpatialHash<>(worldMap.getBound(), 4);

    this.camera = camera;
    this.worldMap = worldMap;
  }

  public void addGameObject(GameObject object) {
    spatialHash.insert(object);
  }

  public void removeGameObject(GameObject object) {
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

    objects.forEach(object -> {
      double x = object.getX() - camera.getX();
      double y = object.getY() - camera.getY();

      object.getSprite().draw(canvas, x, y);
      canvas.drawRectangle(x, y, object.getWidth(), object.getHeight());
    });
  }

  @Override
  public void update(float nano) {
    Set<GameObject> objects = spatialHash.retrieve(camera);

    objects.stream().filter(GameObject::isMovable).forEach(object -> {
      object.update(nano);
      spatialHash.reinsert(object);
    });
  }

  @Override
  public void collide() {
    // collision detection here
  }

  @Override
  public boolean isInitialized() {
    return initialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      getWorldMap().buildWorldMap(this);
      initialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }
}
