package org.borisovich.plague555.app.graphics.sheet;

import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

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
