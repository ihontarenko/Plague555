package org.nulllab.sorrowland.app.graphics.sprite;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.SpritePackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteStaticMapper;

public class TilesASprites extends SpritePackage {

  public TilesASprites() {
    super("tileSet1.set1");
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {
    return new SpriteMapper[] {
        new SpriteStaticMapper("grass1", 1, 52),
        new SpriteStaticMapper("grass2", 1, 86),
        new SpriteStaticMapper("cave", 1, 35),
        new SpriteStaticMapper("ice", 1, 51),
    };
  }

  @Override
  public Sprite getDefaultSprite() {
    return getSprite("grass1");
  }

  @Override
  public String getPackageName() {
    return "tilesA";
  }
}
