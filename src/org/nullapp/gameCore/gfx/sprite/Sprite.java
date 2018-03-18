package org.nullapp.gameCore.gfx.sprite;

import org.nullapp.appCore.common.Drawable;
import org.nullapp.gameCore.geometry.Dimension;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class Sprite implements Drawable {

  private BufferedImage bufferedImage;
  private Dimension     dimension;

  public Sprite(BufferedImage bufferedImage, Dimension dimension) {
    setBufferedImage(bufferedImage);
    setDimension(dimension);
    convertToARGB();
  }

  public Sprite(BufferedImage bufferedImage) {
    this(bufferedImage, new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
  }

  public Sprite(SpriteSheet spriteSheet, int scale, int position) {
    this(spriteSheet.getBufferedImage(position % spriteSheet.count()));
    setScale(scale);
  }

  public Sprite(SpriteSheet spriteSheet, int position) {
    this(spriteSheet.getBufferedImage(position % spriteSheet.count()));
  }

  public Sprite(SpriteSheet spriteSheet) {
    this(spriteSheet.getBufferedImage(1));
  }

  private void convertToARGB() {
    BufferedImage bufferedImage     = getBufferedImage();
    BufferedImage argbBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics      graphics          = argbBufferedImage.getGraphics();

    graphics.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
    setBufferedImage(argbBufferedImage);
  }

  public void draw(Graphics2D g2d, int x, int y) {
    g2d.drawImage(getBufferedImage(), x, y, getWidth(), getHeight(), null);
  }

  public void transparentColor(Color color, float opacity) {
    this.transparentColor(color.getRGB(), opacity);
  }

  public void transparentColor(int color, float opacity) {
    int opacityRate = (int) (0xff * opacity) % 0xff;

    int[] pixels = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());

    for (int i = 0; i < pixels.length; i++) {
      if (pixels[i] == color) {
        pixels[i] = (opacityRate << 24) | (pixels[i] & 0x00ffffff);
      }
    }

    bufferedImage.setRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), pixels, 0, bufferedImage.getWidth());
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public void setBufferedImage(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
  }

  public int getWidth() {
    return getDimension().getWidth();
  }

  public int getHeight() {
    return getDimension().getHeight();
  }

  public Dimension getDimension() {
    return dimension;
  }

  public void setScale(int scale) {
    setDimension(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }

  public void setDimension(int width, int height) {
    setDimension(new Dimension(width, height));
  }

}
