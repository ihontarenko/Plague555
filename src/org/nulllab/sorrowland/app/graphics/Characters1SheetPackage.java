package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetMapper;

public class Characters1SheetPackage extends SpriteSheetPackage {

  public Characters1SheetPackage() {
    super("characters/vx_chara01_a.png");
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("char1", 32, 48, 0, 0, 3, 4),
        new SpriteSheetMapper("char2", 32, 48, 96, 0, 3, 4),
        new SpriteSheetMapper("char3", 32, 48, 192, 0, 3, 4),
        new SpriteSheetMapper("char4", 32, 48, 288, 0, 3, 4),
        new SpriteSheetMapper("char5", 32, 48, 0, 192, 3, 4),
        new SpriteSheetMapper("char6", 32, 48, 96, 192, 3, 4),
        new SpriteSheetMapper("char7", 32, 48, 192, 192, 3, 4),
        new SpriteSheetMapper("char8", 32, 48, 288, 192, 3, 4),
    };
  }
}
