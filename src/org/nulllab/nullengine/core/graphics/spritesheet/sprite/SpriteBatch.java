package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.Canvas;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteBatch extends Sprite {

  public SpriteBatch(BufferedImage[] bufferedImages, int countInWidth) {
    super(bufferedImages);

    BufferedImage bufferedImage = glueImages(getImages(), countInWidth);
    setImages(new BufferedImage[]{bufferedImage});
    setDimension(bufferedImage.getWidth(), bufferedImage.getHeight());
    convertToARGB();
  }

  private BufferedImage glueImages(BufferedImage[] images, int countInWidth) {
    int           countImages = images.length;
    int           width       = images[0].getWidth();
    int           height      = images[0].getHeight();
    int           counter     = 0;
    Dimension     dimension   = new Dimension(width * countInWidth, height * (countImages / countInWidth));
    BufferedImage image       = new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics      graphics    = image.getGraphics();

    for (BufferedImage bufferedImage : images) {
      int factorX = (counter % countInWidth);
      int factorY = (counter / countInWidth);
      graphics.drawImage(bufferedImage, width * factorX, height * factorY, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
      counter++;
    }

    return image;
  }

  @Override
  public void draw(Canvas canvas, double x, double y) {
    super.draw(canvas, x, y);
  }

  @Override
  public void setScale(double scale) {
    super.setScale(scale);
  }

}
