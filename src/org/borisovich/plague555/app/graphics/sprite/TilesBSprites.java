package org.borisovich.plague555.app.graphics.sprite;

import org.borisovich.core.core.graphics.spritesheet.sprite.Sprite;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.SpritePackage;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteMapper;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteStaticMapper;

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
