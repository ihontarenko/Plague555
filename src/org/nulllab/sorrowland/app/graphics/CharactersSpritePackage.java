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
        new SpriteStaticMapper(KEY_STAND_SOUTH, 1, 9),
        new SpriteStaticMapper(KEY_STAND_NORTH, 1, 1),
        new SpriteStaticMapper(KEY_STAND_EAST, 1, 6),
        new SpriteStaticMapper(KEY_STAND_WEST, 1, 3),
        new SpriteAnimatedMapper(KEY_MOVE_SOUTH, 1, 9, 11, 3),
        new SpriteAnimatedMapper(KEY_MOVE_NORTH, 1, 0, 2, 3),
        new SpriteAnimatedMapper(KEY_MOVE_WEST, 1, 6, 8, 3),
        new SpriteAnimatedMapper(KEY_MOVE_EAST, 1, 3, 5, 3),
    };
  }


}
