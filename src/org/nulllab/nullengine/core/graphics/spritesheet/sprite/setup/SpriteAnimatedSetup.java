package org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteAnimated;

public class SpriteAnimatedSetup extends SpriteSetup {

  private int    start;
  private int    end;
  private int    fps;

  private SpriteAnimated.Direction direction;

  public SpriteAnimatedSetup(String name, int scale, int start, int end, int fps) {
    super(SpriteAnimated.class, name, scale);

    this.start = start;
    this.end = end;
    this.fps = fps;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public int getFps() {
    return fps;
  }

  public SpriteAnimated.Direction getDirection() {
    return direction;
  }

}
