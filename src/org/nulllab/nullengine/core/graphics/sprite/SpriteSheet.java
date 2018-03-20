package org.nulllab.nullengine.core.graphics.sprite;

import java.awt.image.BufferedImage;

public class SpriteSheet {

  private BufferedImage bufferedImage;
  private int           sizeX;
  private int           sizeY;
  private int           spriteCount;
  private int           spritesInWidth;
  private int           spritesInHeight;

  public SpriteSheet(BufferedImage sheet) {
    this(sheet, sheet.getWidth(), sheet.getHeight());
  }

  public SpriteSheet(BufferedImage sheet, int size) {
    this(sheet, size, size);
  }

  public SpriteSheet(BufferedImage sheet, int sizeX, int sizeY) {
    this.bufferedImage = sheet;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.spritesInWidth = sheet.getWidth() / sizeX;
    this.spritesInHeight = sheet.getHeight() / sizeY;
    this.spriteCount = this.spritesInWidth * this.spritesInHeight;
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public BufferedImage getBufferedImage(int index) {
    index = index % count();

    int x = index % inWidth() * getSizeX();
    int y = index / inWidth() * getSizeY();

    return getBufferedImage().getSubimage(x, y, getSizeX(), getSizeY());
  }

  public Sprite getSprite(int index) {
    return new Sprite(getBufferedImage(index));
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

  public int getWidth() {
    return getBufferedImage().getWidth();
  }

  public int getHeight() {
    return getBufferedImage().getHeight();
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }
}
