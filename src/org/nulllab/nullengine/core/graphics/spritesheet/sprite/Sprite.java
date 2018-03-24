package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
abstract public class Sprite implements Drawable<Canvas> {

  public static final int DEFAULT_INDEX = 0;
  public static final int DEFAULT_SCALE = 1;
  private BufferedImage[] images;
  private Dimension       dimension;
  private             int active        = DEFAULT_INDEX;

  public Sprite(BufferedImage[] images, Dimension dimension) {
    setImages(images);
    setDimension(dimension);
    convertToARGB();
  }

  public Sprite(BufferedImage[] images) {
    this(images, null);
    setScale(DEFAULT_SCALE);
  }

  private void convertToARGB() {
    BufferedImage[] argbImages = new BufferedImage[images.length];
    int counter = 0;

    for (BufferedImage image : images) {
      argbImages[counter++] = convertToARGB(image);
    }

    setImages(argbImages);
  }

  public static BufferedImage convertToARGB(BufferedImage bufferedImage) {
    BufferedImage argbImage = new BufferedImage(
        bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics      graphics  = argbImage.getGraphics();

    graphics.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

    return argbImage;
  }

  public void draw(Canvas canvas, double x, double y) {
    canvas.drawImage(getActiveImage(), x, y, getWidth(), getHeight());
  }

  public void cutColor(int color, float opacity) {
    int opacityRate = (int) (0xff * opacity) % 0xff;

    for (BufferedImage image : images) {
      int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());

      for (int i = 0; i < pixels.length; i++) {
        if (pixels[i] == color) {
          pixels[i] = (opacityRate << 24) | (pixels[i] & 0x00ffffff);
        }
      }

      image.setRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
    }
  }

  public BufferedImage[] getImages() {
    return images;
  }

  public void setImages(BufferedImage[] images) {
    this.images = images;
  }

  public BufferedImage getActiveImage() {
    return images[active];
  }

  public int getActiveIndex() {
    return active;
  }

  public void setActiveImage(int index) {
    this.active = index % images.length;
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

  public void setScale(double scale) {
    setDimension(new Dimension(getActiveImage().getWidth() * scale, getActiveImage().getHeight() * scale));
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }

  public void setDimension(int width, int height) {
    setDimension(new Dimension(width, height));
  }

}
