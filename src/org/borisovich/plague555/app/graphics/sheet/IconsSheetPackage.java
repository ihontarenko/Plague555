package org.borisovich.plague555.app.graphics.sheet;

import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

public class IconsSheetPackage extends SpriteSheetPackage {

  public IconsSheetPackage() {
    super("sprites/ui/iconset.png");
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("set1", 24, 24, 0, 0, 16, 625),
    };
  }

  @Override
  public String getPackageName() {
    return "iconSet";
  }

}
