package org.nulllab.sorrowland.app.graphics.sheet.characters;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.pack.SpriteSheetMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;

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
