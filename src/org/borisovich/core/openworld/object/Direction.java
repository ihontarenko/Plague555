package org.borisovich.core.openworld.object;

public enum Direction {

  LEFT(-1, 0), RIGHT(1, 0), UP(0, -1), DOWN(0, 1);

  private int factorX;
  private int factorY;

  Direction(int factorX, int factorY) {
    this.factorX = factorX;
    this.factorY = factorY;
  }

  public int getFactorX() {
    return factorX;
  }

  public int getFactorY() {
    return factorY;
  }

}
