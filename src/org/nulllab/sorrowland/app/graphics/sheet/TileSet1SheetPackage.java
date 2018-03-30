package org.nulllab.sorrowland.app.graphics.sheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;

public class TileSet1SheetPackage extends SpriteSheetPackage {

  public TileSet1SheetPackage() {
    super("sprites/tiles/tileSet1.png");
  }

  @Override
  public String getPackageName() {
    return "tiles1";
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("set1", 32, 32, 0, 0, 8, 13)
    };
  }

}
