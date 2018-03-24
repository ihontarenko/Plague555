package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetSetup;

public class WorldTilesSpritePackage extends SpriteSheetPackage {

  public WorldTilesSpritePackage() {
    super("map/tiles1.png");
  }

  @Override
  public SpriteSheetSetup[] getSpriteSheetSetup() {
    return new SpriteSheetSetup[] {
        new SpriteSheetSetup("sheet1", 32, 32, 384, 288, 2, 1),
        new SpriteSheetSetup("sheet2", 32, 32, 320, 288, 2, 1),
        new SpriteSheetSetup("sheet3", 32, 32, 0, 96, 2, 1),
    };
  }

}
