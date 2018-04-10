package org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping;

public class SpriteBatchMapper extends SpriteMapper {

  private int[] positions;
  private int   countInWidth;

  public SpriteBatchMapper(String name, double scale, int[] positions, int countInWidth) {
    this(name, scale, positions, countInWidth, -1);
  }

  public SpriteBatchMapper(String name, double scale, int[] positions, int countInWidth, int color) {
    super(name, scale, color);

    this.positions = positions;
    this.countInWidth = countInWidth;
  }

  public int[] getPositions() {
    return positions;
  }

  public int getCountInWidth() {
    return countInWidth;
  }

}
