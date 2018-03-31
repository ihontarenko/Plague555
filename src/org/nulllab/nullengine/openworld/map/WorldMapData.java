package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.geometry.Bound2D;

import java.util.Map;

public class WorldMapData {

  private int                width;
  private int                height;
  private int                tileSize;
  private Map<Integer, Tile> tiles;
  private String             mapFile;

  public WorldMapData(String mapFile) {
    this.mapFile = mapFile;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void addTile(Tile tile) {
    tiles.put(getPositionFor(tile.getPositionX(), tile.getPositionY()), tile);
  }

  public Tile getTile(int x, int y) {
    return tiles.get(getPositionFor(x, y));
  }

  public int getPositionFor(int positionX, int positionY) {
    return (positionY * width) + positionX;
  }

  public int getX(int positionX) {
    return positionX * tileSize;
  }

  public int getY(int positionY) {
    return positionY * tileSize;
  }

  public int getTileSize() {
    return tileSize;
  }

  public void setTileSize(int tileSize) {
    this.tileSize = tileSize;
  }

  public String getMapFile() {
    return mapFile;
  }

  public void setMapFile(String mapFile) {
    this.mapFile = mapFile;
  }

  public Bound2D getBound() {
    return new Bound2D(0, 0, tileSize * width, tileSize * height);
  }

  public class Tile {

    private String  spriteID;
    private int     positionX;
    private int     positionY;
    private int     layer;
    private boolean isSolid;

    public Tile(int positionX, int positionY, int layer, boolean isSolid, String spriteID) {
      this.spriteID = spriteID;
      this.positionX = positionX;
      this.positionY = positionY;
      this.layer = layer;
      this.isSolid = isSolid;
    }

    public String getSpriteID() {
      return spriteID;
    }

    public void setSpriteID(String spriteID) {
      this.spriteID = spriteID;
    }

    public int getPositionX() {
      return positionX;
    }

    public void setPositionX(int positionX) {
      this.positionX = positionX;
    }

    public int getPositionY() {
      return positionY;
    }

    public void setPositionY(int positionY) {
      this.positionY = positionY;
    }

    public int getLayer() {
      return layer;
    }

    public void setLayer(int layer) {
      this.layer = layer;
    }

    public boolean isSolid() {
      return isSolid;
    }

    public void setSolid(boolean solid) {
      isSolid = solid;
    }

  }

}
