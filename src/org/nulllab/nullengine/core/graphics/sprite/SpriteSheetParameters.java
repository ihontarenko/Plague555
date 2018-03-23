package org.nulllab.nullengine.core.graphics.sprite;

public class SpriteSheetParameters {

  private String name;

  private int sizeX;
  private int sizeY;

  private int offsetX;
  private int offsetY;

  private int countX;
  private int countY;

  public SpriteSheetParameters(String name, int size, int offset, int count) {
    this(name, size, size, offset, offset, count, count);
  }

  public SpriteSheetParameters(String name, int sizeX, int sizeY, int offset, int count) {
    this(name, sizeX, sizeY, offset, offset, count, count);
  }

  public SpriteSheetParameters(String name, int sizeX, int sizeY, int offsetX, int offsetY, int count) {
    this(name, sizeX, sizeY, offsetX, offsetY, count, count);
  }

  public SpriteSheetParameters(String name, int sizeX, int sizeY, int offsetX, int offsetY, int countX, int countY) {
    this.name = name;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.offsetX = offsetX;
    this.offsetY = offsetY;
    this.countX = countX;
    this.countY = countY;
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }

  public int getOffsetX() {
    return offsetX;
  }

  public int getOffsetY() {
    return offsetY;
  }

  public int getCountX() {
    return countX;
  }

  public int getCountY() {
    return countY;
  }

  public String getName() {
    return name;
  }
}
