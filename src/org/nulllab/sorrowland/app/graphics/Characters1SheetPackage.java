package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetSetup;

public class Characters1SheetPackage extends SpriteSheetPackage {

  public Characters1SheetPackage() {
    super("characters/vx_chara01_a.png");
  }

  @Override
  public SpriteSheetSetup[] getSpriteSheetSetup() {
    return new SpriteSheetSetup[] {
        new SpriteSheetSetup("char1", 32, 48, 0, 0, 3, 4)
    };
  }
}
