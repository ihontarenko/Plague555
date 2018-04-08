package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.geometry.Bounds2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMapData {

  private String                   name;
  private int                      width;
  private int                      height;
  private int                      tileSize;
  private Map<Integer, List<Tile>> tiles;
  private String                   mapFile;
  private Tile                     defaultTile;

  public WorldMapData(String mapFile) {
    this.tiles = new HashMap<>();
    this.mapFile = mapFile;
    this.defaultTile = new Tile(0, 0, 0, false, null);
  }

  public Tile getDefaultTile() {
    return defaultTile;
  }

  public void setDefaultTile(Tile defaultTile) {
    this.defaultTile = defaultTile;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    getTiles(tile.getPositionX(), tile.getPositionY()).add(tile);
  }

  public List<Tile> getTiles(int x, int y) {
    return getTiles(getPositionFor(x, y));
  }

  public List<Tile> getTiles(int position) {
    List<Tile> tiles = this.tiles.get(position);

    if (!hasTiles(position)) {
      tiles = new ArrayList<>();
      this.tiles.put(position, tiles);
    }

    return tiles;
  }

  public Tile getTile(int x, int y, int position) {
    return getTiles(x, y).get(position);
  }

  public boolean hasTiles(int x, int y) {
    return hasTiles(getPositionFor(x, y));
  }

  public boolean hasTiles(int position) {
    return tiles.containsKey(position);
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

  public Bounds2D getBound() {
    return new Bounds2D(0, 0, tileSize * width, tileSize * height);
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

    public int getX() {
      return WorldMapData.this.getX(getPositionX());
    }

    public int getY() {
      return WorldMapData.this.getY(getPositionY());
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
