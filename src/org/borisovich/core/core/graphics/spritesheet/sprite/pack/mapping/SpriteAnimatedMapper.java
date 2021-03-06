package org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping;

import org.borisovich.core.core.graphics.spritesheet.sprite.SpriteAnimated;

public class SpriteAnimatedMapper extends SpriteMapper {

  private int    start;
  private int    end;
  private int    fps;

  private SpriteAnimated.LoopType loopType;

  public SpriteAnimatedMapper(String name, double scale, int start, int end, int fps) {
    this(name, scale, start, end, fps, SpriteAnimated.LoopType.PING_PONG, -1);
  }

  public SpriteAnimatedMapper(String name, double scale, int start, int end, int fps, int color) {
    this(name, scale, start, end, fps, SpriteAnimated.LoopType.PING_PONG, color);
  }

  public SpriteAnimatedMapper(String name, double scale, int start, int end, int fps, SpriteAnimated.LoopType loopType, int color) {
    super(name, scale, color);

    this.start = start;
    this.end = end;
    this.fps = fps;
    this.loopType = loopType;
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

  public SpriteAnimated.LoopType getLoopType() {
    return loopType;
  }

}
