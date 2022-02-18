package org.borisovich.plague555.app.graphics.sheet.characters;

import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

public class OrcAssassinAPackage extends SpriteSheetPackage {

  public OrcAssassinAPackage() {
    super("sprites/characters/monsters/OrcAssassin_A.png");
  }

  @Override
  public SpriteSheetMapper[] getSpriteSheetMappers() {
    return new SpriteSheetMapper[] {
        new SpriteSheetMapper("orc", 32, 32, 0, 0, 3, 4),
    };
  }

  @Override
  public String getPackageName() {
    return "orcA";
  }

}
