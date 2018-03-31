package org.nulllab.sorrowland.app.graphics.sprite;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteAnimatedMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteStaticMapper;
import org.nulllab.nullengine.openworld.character.Sprites;

abstract public class SpritesDefaultMapper extends Sprites {

  public SpritesDefaultMapper(String sheetID) {
    super(sheetID);
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {
    return new SpriteMapper[] {
        new SpriteStaticMapper(KEY_STAND_NORTH, 1, 9),
        new SpriteStaticMapper(KEY_STAND_SOUTH, 1, 1),
        new SpriteStaticMapper(KEY_STAND_EAST, 1, 6),
        new SpriteStaticMapper(KEY_STAND_WEST, 1, 3),
        new SpriteAnimatedMapper(KEY_MOVE_NORTH, 1, 9, 11, 5, 0x78c380),
        new SpriteAnimatedMapper(KEY_MOVE_SOUTH, 1, 0, 2, 5),
        new SpriteAnimatedMapper(KEY_MOVE_EAST, 1, 6, 8, 5),
        new SpriteAnimatedMapper(KEY_MOVE_WEST, 1, 3, 5, 5, 0x78c380),
    };
  }
}
