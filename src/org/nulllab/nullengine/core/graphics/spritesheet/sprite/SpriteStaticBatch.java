package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.Canvas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class SpriteStaticBatch extends Sprite {

  public SpriteStaticBatch(BufferedImage[] bufferedImages, int countInWidth) {
    super(bufferedImages);

    BufferedImage bufferedImage = glueImages(Arrays.asList(getImages()), countInWidth);
    setImages(new BufferedImage[]{bufferedImage});
    setDimension(bufferedImage.getWidth(), bufferedImage.getHeight());
    convertToARGB();
  }

  private BufferedImage glueImages(List<BufferedImage> bufferedImages, int countInWidth) {
    int           countImages   = bufferedImages.size();
    int           width         = bufferedImages.get(0).getWidth();
    int           height        = bufferedImages.get(0).getHeight();
    int           counter       = 0;
    Dimension     dimension     = new Dimension(width * countInWidth, height * (countImages / countInWidth));
    BufferedImage bufferedImage = new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics      graphics      = bufferedImage.getGraphics();

    for (BufferedImage image : bufferedImages) {
      int factorX = (counter % countInWidth);
      int factorY = (counter / countInWidth);
      graphics.drawImage(image, width * factorX, height * factorY, image.getWidth(), image.getHeight(), null);
      counter++;
    }

    return bufferedImage;
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
