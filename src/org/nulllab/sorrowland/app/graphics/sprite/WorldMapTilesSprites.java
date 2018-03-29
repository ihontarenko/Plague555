package org.nulllab.sorrowland.app.graphics.sprite;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteStaticMapper;
import org.nulllab.sorrowland.app.graphics.sheet.WorldTilesSpritePackage;

public class WorldMapTilesSprites extends SpritePackage {

  public WorldMapTilesSprites() {
    super(WorldTilesSpritePackage.class, "grass");
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {
    return new SpriteMapper[] {
        new SpriteStaticMapper("grass", 1, 0)
    };
  }

  @Override
  public Sprite getDefaultSprite() {
    return null;
  }

}
