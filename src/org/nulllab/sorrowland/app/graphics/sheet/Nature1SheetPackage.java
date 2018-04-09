package org.nulllab.sorrowland.app.graphics.sheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;

public class Nature1SheetPackage extends SpriteSheetPackage {

  public Nature1SheetPackage() {
    super("sprites/world/nature1.png");
  }

  @Override
  public String getPackageName() {
    return "nature1";
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("set1", 30, 30, 0, 0, 8, 16)
    };
  }

}
