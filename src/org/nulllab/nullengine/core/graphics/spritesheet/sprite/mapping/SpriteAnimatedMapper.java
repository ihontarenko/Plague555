package org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteAnimated;

public class SpriteAnimatedMapper extends SpriteMapper {

  private int    start;
  private int    end;
  private int    fps;

  private SpriteAnimated.Direction direction;

  public SpriteAnimatedMapper(String name, int scale, int start, int end, int fps) {
    this(name, scale, start, end, fps, SpriteAnimated.Direction.PING_PONG);
  }

  public SpriteAnimatedMapper(String name, int scale, int start, int end, int fps, SpriteAnimated.Direction direction) {
    super(SpriteAnimated.class, name, scale);

    this.start = start;
    this.end = end;
    this.fps = fps;
    this.direction = direction;
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
