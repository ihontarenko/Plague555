package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.common.time.Timer;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;

public class SpriteAnimated extends Sprite {

  public enum LoopType {
    LOOPED, PING_PONG
  }

  public static final int DEFAULT_FPS = 30;

  private LoopType loopType;
  private Timer    timer;
  private int      incrementer;

  public SpriteAnimated(SpriteSheet sheet) {
    this(sheet, DEFAULT_FPS, DEFAULT_SCALE, DEFAULT_INDEX, sheet.count(), LoopType.LOOPED);
  }

  public SpriteAnimated(SpriteSheet sheet, int fps) {
    this(sheet, fps, DEFAULT_SCALE, DEFAULT_INDEX, sheet.count(), LoopType.LOOPED);
  }

  public SpriteAnimated(SpriteSheet sheet, int fps, double scale) {
    this(sheet, fps, scale, DEFAULT_INDEX, sheet.count(), LoopType.LOOPED);
  }

  public SpriteAnimated(SpriteSheet sheet, int fps, double scale, int startIndex, int lastIndex) {
    this(sheet, fps, scale, startIndex, lastIndex, LoopType.LOOPED);
  }

  public SpriteAnimated(SpriteSheet sheet, int fps, double scale, int startIndex, int lastIndex, LoopType loopType) {
    super(sheet.getBufferedImages(startIndex, lastIndex));
    setScale(scale);
    this.incrementer = 1;
    this.loopType = loopType;
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
    switch (loopType) {
      case PING_PONG:
        if (getActiveIndex() == countImages() - 1) {
          incrementer = -1;
        } else if (getActiveIndex() == 0) {
          incrementer = 1;
        }
        break;
      case LOOPED:
        // default
    }
  }

  public LoopType getLoopType() {
    return loopType;
  }

  public void setLoopType(LoopType loopType) {
    this.loopType = loopType;
  }
}
