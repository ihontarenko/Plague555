package org.nulllab.sorrowland.app.graphics.sheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;

abstract public class Characters4x2Package extends SpriteSheetPackage {

  public Characters4x2Package(String filename) {
    super(filename);
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
