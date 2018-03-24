package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;

import java.awt.image.BufferedImage;

public class SpriteStatic extends Sprite {

  public SpriteStatic(BufferedImage bufferedImage, Dimension dimension) {
    super(new BufferedImage[]{bufferedImage}, dimension);
  }

  public SpriteStatic(BufferedImage bufferedImage) {
    super(new BufferedImage[]{bufferedImage});
  }

  public SpriteStatic(SpriteSheet spriteSheet, double scale, int position) {
    this(spriteSheet.getBufferedImage(position % spriteSheet.count()));
    setScale(scale);
  }

  public SpriteStatic(SpriteSheet spriteSheet, int position) {
    this(spriteSheet.getBufferedImage(position % spriteSheet.count()));
  }

  public SpriteStatic(SpriteSheet spriteSheet) {
    this(spriteSheet.getBufferedImage(0));
  }

}
