package org.plagueinc.sorrowland.core.gfx;

import org.plagueinc.sorrowland.core.common.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite implements Drawable {

  protected BufferedImage image;
  protected SpriteSheet sheet;
  protected int index;

  public Sprite(SpriteSheet sheet, int scale, int index) {
    this.sheet = sheet;
    this.index = index % sheet.count();

    BufferedImage origin = getSheet().getSprite(this.index);
    BufferedImage actual = new BufferedImage(origin.getWidth() * scale, origin.getHeight() * scale, BufferedImage.TYPE_INT_ARGB);
    actual.getGraphics().drawImage(origin, 0, 0, actual.getWidth(), actual.getHeight(), null);

    this.image = actual;
  }

  public void draw(Graphics2D g2d, int x, int y) {
    g2d.drawImage(getImage(), x, y, getImage().getWidth(), getImage().getHeight(), null);
  }

  public void transparentColor(Color color, float opacity) {
    this.transparentColor(color.getRGB(), opacity);
  }

  public void transparentColor(int color, float opacity) {
    int opacityRate = (int) ((0xff / 100.0f) * (opacity * 100));

    int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());

    for (int i = 0; i < pixels.length; i++) {
      if (pixels[i] == color) {
        pixels[i] = (opacityRate << 24) | (pixels[i] & 0x00ffffff);
      }
    }

    image.setRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
  }

  public BufferedImage getImage() {
    return image;
  }

  public SpriteSheet getSheet() {
    return sheet;
  }
}
