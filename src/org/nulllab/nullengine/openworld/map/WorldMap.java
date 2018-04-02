package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.openworld.World;

public class WorldMap implements Initializable {

  private boolean initialized = false;
  private WorldMapData worldMapData;

  public WorldMap(String mapFile) {
    this.worldMapData = new WorldMapData(mapFile);
  }

  public Bound2D getBound() {
    return getWorldMapData().getBound();
  }

  public WorldMapData getWorldMapData() {
    return worldMapData;
  }

  public void buildWorldMap(World world) {
    WorldMapData      data            = getWorldMapData();
    String            defaultSpriteID = data.getDefaultTile().getSpriteID();
    int               tileSize        = data.getTileSize();
    int               width           = data.getWidth();
    int               height          = data.getHeight();
    WorldMapData.Tile tile;

    for (int positionX = 0; positionX < width; positionX++) {
      for (int positionY = 0; positionY < height; positionY++) {

        Terrain terrain = new Terrain(data.getX(positionX), data.getY(positionY), tileSize, tileSize);
        terrain.setSprite(defaultSpriteID);

        if (data.hasTile(positionX, positionY)) {
          tile = data.getTile(positionX, positionY);
          terrain.setSprite(tile.getSpriteID());
          terrain.setSolid(tile.isSolid());
          terrain.setLayer(tile.getLayer());
        }

        world.addGameObject(terrain);
      }
    }
  }

  @Override
  public boolean isInitialized() {
    return initialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      System.out.printf("WorldMap: start parse map '%s'%n", getWorldMapData().getMapFile());
      WorldMapLoader loader = new WorldMapLoader(getWorldMapData().getMapFile());
      loader.toMapData(getWorldMapData());
      System.out.printf("WorldMap: parsed map '%s'%n", getWorldMapData().getName());
      initialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }
}
