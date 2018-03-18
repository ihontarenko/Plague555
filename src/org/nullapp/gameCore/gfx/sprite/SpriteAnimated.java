package org.nullapp.gameCore.gfx.sprite;

import org.nullapp.appCore.common.Drawable;
import org.nullapp.appCore.common.Time;

import java.awt.*;

public class SpriteAnimated implements Drawable {

  private Sprite[]    sprites;
  private SpriteSheet sheet;
  private int         scale;
  private int         activeIndex;
  private int         speedAnimation;
  private long        lastTimeUpdate;
  private int         transparentColor;
  private float       opacity;


  public SpriteAnimated(SpriteSheet sheet, int speedAnimation, int scale) {
    this(sheet, speedAnimation, scale, 0, sheet.count());
  }

  public SpriteAnimated(SpriteSheet sheet, int speedAnimation, int scale, int startIndex, int lastIndex) {
    this.sheet = sheet;
    this.scale = scale;
    this.speedAnimation = speedAnimation;
    this.sprites = new Sprite[lastIndex - startIndex + 1];
    this.transparentColor = 0x00000000;
    this.transparentColor = 0x00000000;
    this.loadSprites(startIndex, lastIndex);
  }

  private void loadSprites(int startIndex, int lastIndex) {
    int count = 0;
    for (int i = startIndex; i <= lastIndex; i++) {
      sprites[count++] = new Sprite(sheet, scale, i);
    }
  }

  private void nextIndex() {
    long elapsedTime = Time.nano() - lastTimeUpdate;

    if ((elapsedTime / (Time.ONE_NANO_SECOND / speedAnimation)) >= 1) {
      lastTimeUpdate = Time.nano();
      activeIndex = (activeIndex + 1) % sprites.length;
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

  public int getSpeedAnimation() {
    return speedAnimation;
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
}
