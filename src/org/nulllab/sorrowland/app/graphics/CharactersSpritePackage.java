package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteAnimatedMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteStaticMapper;
import org.nulllab.nullengine.openworld.character.CharacterSpritePackage;

public class CharactersSpritePackage extends CharacterSpritePackage {

  public CharactersSpritePackage() {
    super(Characters1SheetPackage.class, "char8");
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {
    return new SpriteMapper[] {
        new SpriteStaticMapper("turnUp", 1, 9),
        new SpriteStaticMapper("turnDown", 1, 1),
        new SpriteStaticMapper("turnRight", 1, 6),
        new SpriteStaticMapper("turnLeft", 1, 3),
        new SpriteAnimatedMapper("moveUp", 1, 9, 11, 3),
        new SpriteAnimatedMapper("moveDown", 1, 0, 2, 3),
        new SpriteAnimatedMapper("moveRight", 1, 6, 8, 3),
        new SpriteAnimatedMapper("moveLeft", 1, 3, 5, 3),
    };
  }


}
