package org.borisovich.core.openworld.world.map;

import org.borisovich.core.core.common.Initializable;
import org.borisovich.core.core.geometry.Bounds2D;
import org.borisovich.core.openworld.World;
import org.borisovich.core.openworld.object.component.graphics.Graphics;

public class WorldMap implements Initializable {

  private boolean initialized = false;
  private WorldMapData worldMapData;

  public WorldMap(String mapFile) {
    this.worldMapData = new WorldMapData(mapFile);
  }

  public Bounds2D getBound() {
    return getWorldMapData().getBound();
  }

  public WorldMapData getWorldMapData() {
    return worldMapData;
  }

  public void buildWorldMap(World world) {
    WorldMapData data            = getWorldMapData();
    String       defaultSpriteID = data.getDefaultTile().getSpriteID();
    int          size            = data.getTileSize();
    int          width           = data.getWidth();
    int          height          = data.getHeight();

    for (int positionX = 0; positionX < width; positionX++) {
      for (int positionY = 0; positionY < height; positionY++) {

        final int x = data.getX(positionX);
        final int y = data.getY(positionY);

        Terrain  defaultTerrain         = createTerrainObject(x, y, size, world);
        Graphics defaultTerrainGraphics = defaultTerrain.getGraphics();
        defaultTerrainGraphics.setSpriteFromPackage(defaultSpriteID);

        if (data.hasTiles(positionX, positionY)) {
          data.getTiles(positionX, positionY).forEach(tile -> {
            Terrain  terrain  = createTerrainObject(x, y, size, world);
            Graphics graphics = terrain.getGraphics();
            graphics.setSpriteFromPackage(tile.getSpriteID());
            terrain.setSolid(tile.isSolid());
            terrain.setPriority(tile.getLayer());
          });
        }
      }
    }
  }

  private Terrain createTerrainObject(int x, int y, int tileSize, World world) {
    Terrain terrain = new Terrain(x, y, tileSize, tileSize);
    world.addGameObject(terrain);

    return terrain;
  }

  @Override
  public boolean isInitialized() {
    return initialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      WorldMapLoader loader = new WorldMapLoader(getWorldMapData().getMapFile());
      loader.toMapData(getWorldMapData());
      initialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }
}
