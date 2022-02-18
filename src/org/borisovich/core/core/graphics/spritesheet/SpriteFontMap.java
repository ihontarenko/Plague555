package org.borisovich.core.core.graphics.spritesheet;

import java.util.HashMap;
import java.util.Map;

abstract public class SpriteFontMap {

  private Map<Integer, Integer> map;

  public SpriteFontMap() {
    this.map = new HashMap<>();

    int[] chars     = getChars();
    int[] positions = getPositions();

    if (chars.length != positions.length) {
      throw new RuntimeException("Length of position points and chars should been equals");
    }

    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], positions[i]);
    }
  }

  public int getPosition(int charCode) {
    return map.get(charCode);
  }

  public int getPosition(char charCode) {
    return getPosition((int) charCode);
  }

  abstract protected int[] getChars();

  abstract protected int[] getPositions();

}
