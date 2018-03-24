package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteSheet;

import java.awt.image.BufferedImage;

public class StaticSprite extends Sprite {

  public StaticSprite(BufferedImage bufferedImage, Dimension dimension) {
    super(new BufferedImage[]{bufferedImage}, dimension);
  }

  public StaticSprite(BufferedImage bufferedImage) {
    super(new BufferedImage[]{bufferedImage});
  }

  public StaticSprite(SpriteSheet spriteSheet, double scale, int position) {
    this(spriteSheet.getBufferedImage(position % spriteSheet.count()));
    setScale(scale);
  }

  public StaticSprite(SpriteSheet spriteSheet, int position) {
    this(spriteSheet.getBufferedImage(position % spriteSheet.count()));
  }

  public StaticSprite(SpriteSheet spriteSheet) {
    this(spriteSheet.getBufferedImage(0));
  }

}
