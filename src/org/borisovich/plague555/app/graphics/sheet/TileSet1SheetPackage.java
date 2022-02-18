package org.borisovich.plague555.app.graphics.sheet;

import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

public class TileSet1SheetPackage extends SpriteSheetPackage {

  public TileSet1SheetPackage() {
    super("sprites/tiles/tileSet1.png");
  }

  @Override
  public String getPackageName() {
    return "tileSet1";
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("set1", 32, 32, 0, 0, 8, 13)
    };
  }

}
