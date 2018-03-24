package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;

abstract public class CharacterSpritePackage extends SpritePackage {

  public CharacterSpritePackage(String name, SpriteSheet spriteSheet) {
    super(name, spriteSheet);
  }

  public Sprite getMoveSprite(String direction) {
    return getSprite(direction);
  }

}
