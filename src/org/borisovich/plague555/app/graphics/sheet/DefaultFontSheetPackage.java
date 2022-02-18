package org.borisovich.plague555.app.graphics.sheet;

import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

public class DefaultFontSheetPackage extends SpriteSheetPackage {

  public DefaultFontSheetPackage() {
    super("sprites/fonts/font.png");
  }

  @Override
  public String getPackageName() {
    return "font";
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("map1", 16, 16, 0, 0, 16, 16),
    };
  }
}
