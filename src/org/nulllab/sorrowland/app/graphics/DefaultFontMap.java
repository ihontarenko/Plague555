package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteFontMap;

import java.util.stream.IntStream;

public class DefaultFontMap extends SpriteFontMap {

  @Override
  protected int[] getChars() {
    return IntStream.rangeClosed(0, 255).toArray();
  }

  @Override
  protected int[] getPositions() {
    return IntStream.rangeClosed(0, 255).toArray();
  }
}
