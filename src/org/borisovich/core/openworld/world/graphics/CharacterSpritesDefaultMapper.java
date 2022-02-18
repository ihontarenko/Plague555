package org.borisovich.core.openworld.world.graphics;

import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteAnimatedMapper;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteMapper;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteStaticMapper;
import org.borisovich.core.openworld.character.Sprites;

abstract public class CharacterSpritesDefaultMapper extends Sprites {

  public CharacterSpritesDefaultMapper(String sheetID) {
    super(sheetID);
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {

    final int ANIMATION_FPS = 10;
    final int OPACITY_COLOR = 0x78c380;

    return new SpriteMapper[] {
        new SpriteStaticMapper(KEY_STAND_NORTH, 1, 10, OPACITY_COLOR),
        new SpriteStaticMapper(KEY_STAND_SOUTH, 1, 1, OPACITY_COLOR),
        new SpriteStaticMapper(KEY_STAND_EAST, 1, 7, OPACITY_COLOR),
        new SpriteStaticMapper(KEY_STAND_WEST, 1, 4, OPACITY_COLOR),
        new SpriteAnimatedMapper(KEY_MOVE_NORTH, 1, 9, 11, ANIMATION_FPS, OPACITY_COLOR),
        new SpriteAnimatedMapper(KEY_MOVE_SOUTH, 1, 0, 2, ANIMATION_FPS, OPACITY_COLOR),
        new SpriteAnimatedMapper(KEY_MOVE_EAST, 1, 6, 8, ANIMATION_FPS, OPACITY_COLOR),
        new SpriteAnimatedMapper(KEY_MOVE_WEST, 1, 3, 5, ANIMATION_FPS, OPACITY_COLOR),
    };
  }
}
