package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.common.time.Timer;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteSheet;

public class DinamicSprite extends Sprite {

  public enum Direction {
    LOOPED, PING_PONG
  }

  public static final int DEFAULT_FPS = 30;

  private Direction      direction;
  private Timer          timer;
  private int            incrementer;

  public DinamicSprite(SpriteSheet sheet) {
    this(sheet, DEFAULT_FPS, 1, 0, sheet.count(), Direction.LOOPED);
  }

  public DinamicSprite(SpriteSheet sheet, int fps) {
    this(sheet, fps, 1, 0, sheet.count(), Direction.LOOPED);
  }

  public DinamicSprite(SpriteSheet sheet, int fps, double scale) {
    this(sheet, fps, scale, 0, sheet.count(), Direction.LOOPED);
  }

  public DinamicSprite(SpriteSheet sheet, int fps, double scale, int startIndex, int lastIndex) {
    this(sheet, fps, scale, startIndex, lastIndex, Direction.LOOPED);
  }

  public DinamicSprite(SpriteSheet sheet, int fps, double scale, int startIndex, int lastIndex, Direction direction) {
    super(sheet.getBufferedImages(startIndex, lastIndex));
    setScale(scale);
    this.incrementer = 1;
    this.direction = direction;
    this.timer = new Timer(1D / fps);
  }

  @Override
  public void draw(Canvas canvas, double x, double y) {
    nextIndex();
    super.draw(canvas, x, y);
  }

  private void nextIndex() {
    if (timer.isElapsedThenPurge()) {
      updateIncrementer();
      setActiveImage(getActiveIndex() + incrementer);
    }
  }

  private void updateIncrementer() {
    switch (direction) {
      case PING_PONG:
        if (getActiveIndex() == getImages().length - 1) {
          incrementer = -1;
        } else if (getActiveIndex() == 0) {
          incrementer = 1;
        }
        break;
      case LOOPED:
        // default
    }
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
