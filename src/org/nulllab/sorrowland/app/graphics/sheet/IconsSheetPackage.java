package org.nulllab.sorrowland.app.graphics.sheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;

public class IconsSheetPackage extends SpriteSheetPackage {

  public IconsSheetPackage() {
    super("sprites/ui/iconset.png");
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("icons", 24, 24, 0, 0, 16, 625),
    };
  }

}
