package org.nulllab.gameCore.gfx.sprite;

import org.nulllab.appCore.common.Drawable;
import org.nulllab.appCore.common.SystemTime;

import java.awt.*;

public class SpriteAnimated implements Drawable {

  public enum Direction {
    LOOPED, PINGPONG;
  }

  private Sprite[]    sprites;
  private SpriteSheet sheet;
  private Direction   direction;
  private int         scale;
  private int         activeIndex;
  private int         incrementer;
  private int         fps;
  private long        previousTime;
  private int         transparentColor;
  private float       opacity;

  public SpriteAnimated(SpriteSheet sheet, int fps, int scale) {
    this(sheet, fps, scale, 0, sheet.count(), Direction.LOOPED);
  }

  public SpriteAnimated(SpriteSheet sheet, int fps, int scale, int startIndex, int lastIndex) {
    this(sheet, fps, scale, startIndex, lastIndex, Direction.LOOPED);
  }

  public SpriteAnimated(SpriteSheet sheet, int fps, int scale, int startIndex, int lastIndex, Direction direction) {
    this.sheet = sheet;
    this.scale = scale;
    this.fps = fps;
    this.sprites = new Sprite[lastIndex - startIndex + 1];
    this.transparentColor = 0x00000000;
    this.incrementer = 1;
    this.direction = direction;
    this.loadSprites(startIndex, lastIndex);
  }

  private void loadSprites(int startIndex, int lastIndex) {
    int count = 0;
    for (int i = startIndex; i <= lastIndex; i++) {
      sprites[count++] = new Sprite(sheet, scale, i);
    }
  }

  private void nextIndex() {
    long elapsed = SystemTime.nano() - previousTime;

    if ((elapsed / (SystemTime.ONE_NANO_SECOND / fps)) >= 1) {
      updateIncrementer();
      previousTime = SystemTime.nano();
      activeIndex = (activeIndex + incrementer) % sprites.length;
    }
  }

  private void updateIncrementer() {
    switch (direction) {
      case PINGPONG:
        if (activeIndex == sprites.length - 1) {
          incrementer = -1;
        } else if (activeIndex == 0) {
          incrementer = 1;
        }
        break;
      case LOOPED:
        // default
    }
  }

  public Sprite activeSprite() {
    nextIndex();
    return getSprite(activeIndex);
  }

  @Override
  public void draw(Graphics2D g2d, int x, int y) {
    Sprite sprite = activeSprite();
    sprite.transparentColor(getTransparentColor(), getOpacity());
    sprite.draw(g2d, x, y);
  }

  public Sprite getSprite(int index) {
    return sprites[index];
  }

  public Sprite[] getSprites() {
    return sprites;
  }

  public SpriteSheet getSheet() {
    return sheet;
  }

  public int getScale() {
    return scale;
  }

  public int getFps() {
    return fps;
  }

  public int getTransparentColor() {
    return transparentColor;
  }

  public void setTransparentColor(int transparentColor) {
    this.transparentColor = transparentColor;
  }

  public float getOpacity() {
    return opacity;
  }

  public void setOpacity(float opacity) {
    this.opacity = opacity;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

}
