package org.nulllab.sorrowland.app.graphics.sheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

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
