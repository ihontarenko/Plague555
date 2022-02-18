package org.borisovich.plague555.app.graphics;

import org.borisovich.core.core.graphics.spritesheet.SpriteFontMap;

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
