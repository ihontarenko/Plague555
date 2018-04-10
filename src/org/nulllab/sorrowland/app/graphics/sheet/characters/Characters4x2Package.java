package org.nulllab.sorrowland.app.graphics.sheet.characters;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

abstract public class Characters4x2Package extends SpriteSheetPackage {

  public Characters4x2Package(String filename) {
    super(filename);
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("c1", 32, 48, 0, 0, 3, 4),
        new SpriteSheetMapper("c2", 32, 48, 96, 0, 3, 4),
        new SpriteSheetMapper("c3", 32, 48, 192, 0, 3, 4),
        new SpriteSheetMapper("c4", 32, 48, 288, 0, 3, 4),
        new SpriteSheetMapper("c5", 32, 48, 0, 192, 3, 4),
        new SpriteSheetMapper("c6", 32, 48, 96, 192, 3, 4),
        new SpriteSheetMapper("c7", 32, 48, 192, 192, 3, 4),
        new SpriteSheetMapper("c8", 32, 48, 288, 192, 3, 4),
    };
  }
}
