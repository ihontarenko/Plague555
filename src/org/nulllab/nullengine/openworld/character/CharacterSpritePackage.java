package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;

abstract public class CharacterSpritePackage extends SpritePackage {

  public CharacterSpritePackage(Class<? extends SpriteSheetPackage> packageClass, String sheetName) {
    super(packageClass, sheetName);
  }

  public Sprite getMoveSprite(String direction) {
    return getSprite(direction);
  }

}
