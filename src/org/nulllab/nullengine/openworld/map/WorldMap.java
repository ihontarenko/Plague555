package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.openworld.World;

public class WorldMap {

  public static final int WIDTH = 500;
  public static final int HEIGHT = 300;
  public static final int TILE_SIZE = 1 << 5;

  private Terrain[][] terrains = new Terrain[WIDTH][HEIGHT];
  private World world;

  public WorldMap(World world) {
    this.world = world;
  }

  public void buildMap() {
    for (int w = 0; w < WIDTH; w++) {
      for (int h = 0; h < HEIGHT; h++) {
        Terrain terrain = new Terrain(Terrain.Type.GRASS);

        terrain.setHeight(TILE_SIZE);
        terrain.setWidth(TILE_SIZE);
        terrain.setX(w * TILE_SIZE);
        terrain.setY(h * TILE_SIZE);

        terrains[w][h] = terrain;
        world.addGameObject(terrain);
      }
    }
  }

  public int getWidthInPixels() {
   return TILE_SIZE * WIDTH;
  }

  public int getHeightInPixels() {
    return TILE_SIZE * HEIGHT;
  }

}
