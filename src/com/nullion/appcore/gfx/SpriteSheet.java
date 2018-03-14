package com.nullion.appcore.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

  private BufferedImage sheet;
  private int           sizeX;
  private int           sizeY;
  private int           spriteCount;
  private int           spritesInWidth;
  private int           spritesInHeight;

  public SpriteSheet(BufferedImage sheet, int size) {
    this(sheet, size, size);
  }

  public SpriteSheet(BufferedImage sheet, int sizeX, int sizeY) {
    this.sheet = sheet;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.spritesInWidth = sheet.getWidth() / sizeX;
    this.spritesInHeight = sheet.getHeight() / sizeY;
    this.spriteCount = this.spritesInWidth * this.spritesInHeight;
  }

  public BufferedImage getSprite(int index) {
    index = index % count();

    int x = index % inWidth() * getSizeX();
    int y = index / inWidth() * getSizeY();

    return getSheet().getSubimage(x, y, getSizeX(), getSizeY());
  }

  public int inHeight() {
    return this.spritesInHeight;
  }

  public int inWidth() {
    return this.spritesInWidth;
  }

  public int count() {
    return this.spriteCount;
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }

  public BufferedImage getSheet() {
    return sheet;
  }
}
