package org.nulllab.sorrowland.app.graphics.sheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetMapper;

public class TileSet2SheetPackage extends SpriteSheetPackage {

  public TileSet2SheetPackage() {
    super("sprites/tiles/tileSet2.png");
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("sheet1", 32, 32, 384, 288, 2, 1),
        new SpriteSheetMapper("sheet2", 32, 32, 320, 288, 2, 1),
        new SpriteSheetMapper("setA", 32, 32, 0, 0, 16, 1),
    };
  }

  @Override
  public String getPackageName() {
    return "tileSet2";
  }

}
