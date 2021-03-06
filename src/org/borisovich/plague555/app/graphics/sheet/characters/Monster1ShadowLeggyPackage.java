package org.borisovich.plague555.app.graphics.sheet.characters;

import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

public class Monster1ShadowLeggyPackage extends SpriteSheetPackage {

  public Monster1ShadowLeggyPackage() {
    super("sprites/characters/monsters/Monsters1_ShadowLeggy1.0.png");
  }

  @Override
  public String getPackageName() {
    return "mp1";
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("monster1", 32, 32, 0, 0, 3, 4),
        new SpriteSheetMapper("monster2", 32, 32, 96, 0, 3, 4),
        new SpriteSheetMapper("monster3", 32, 32, 192, 0, 3, 4),
        new SpriteSheetMapper("monster4", 32, 32, 288, 0, 3, 4),
        new SpriteSheetMapper("monster5", 32, 32, 0, 128, 3, 4),
        new SpriteSheetMapper("monster6", 32, 32, 96, 128, 3, 4),
        new SpriteSheetMapper("monster7", 32, 32, 192, 128, 3, 4),
    };
  }

}
