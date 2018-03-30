package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.World;

public class WorldMap {

  public static final int WIDTH = 40;
  public static final int HEIGHT = 90;
  public static final int TILE_SIZE = 1 << 5;

  private Terrain[][] terrains = new Terrain[WIDTH][HEIGHT];
  private World world;

  public WorldMap(World world) {
    this.world = world;
  }

  public void buildMap() {
    for (int w = 0; w < WIDTH; w++) {
      for (int h = 0; h < HEIGHT; h++) {
        Terrain terrain = new Terrain(w * TILE_SIZE, h * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        terrains[w][h] = terrain;
        world.addGameObject(terrain);
      }
    }

    SpriteManager spriteManager = ServiceLocator.getInstance().getSpriteManager();

    terrains[20][20].setSprite(spriteManager.getSpriteFromPackage("tiles.cave"));
  }

  public Bound2D getBound() {
    return new Bound2D(0, 0, TILE_SIZE * WIDTH, TILE_SIZE * HEIGHT);
  }

}
