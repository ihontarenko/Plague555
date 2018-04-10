package org.nulllab.sorrowland.app.graphics.sprite;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.SpritePackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteStaticMapper;

public class TilesBSprites extends SpritePackage {

  public TilesBSprites() {
    super("tileSet2.setA");
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {
    return new SpriteMapper[] {
        new SpriteStaticMapper("grassDefault", 1, 0),
        new SpriteStaticMapper("grass1", 1, 10),
        new SpriteStaticMapper("grass2", 1, 11),
    };
  }

  @Override
  public Sprite getDefaultSprite() {
    return getSprite("grass1");
  }

  @Override
  public String getPackageName() {
    return "tilesB";
  }

}
