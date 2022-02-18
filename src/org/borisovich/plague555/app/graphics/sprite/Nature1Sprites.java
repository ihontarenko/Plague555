package org.borisovich.plague555.app.graphics.sprite;

import org.borisovich.core.core.graphics.spritesheet.sprite.Sprite;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.SpritePackage;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteBatchMapper;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteMapper;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.mapping.SpriteStaticMapper;

public class Nature1Sprites extends SpritePackage {

  public Nature1Sprites() {
    super("nature1.set1");
  }

  @Override
  public SpriteMapper[] getSpriteMappers() {
    double scale = 1.07D;

    return new SpriteMapper[]{
        new SpriteStaticMapper("bush1", scale, 1),
        new SpriteStaticMapper("bush2", scale, 2),
        new SpriteStaticMapper("bush3", scale, 3),
        new SpriteStaticMapper("stump1", scale, 4),
        new SpriteStaticMapper("stone1", scale, 5),
        new SpriteStaticMapper("stone2", scale, 6),
        new SpriteStaticMapper("stone3", scale, 7),
        new SpriteStaticMapper("grass1", scale, 8),
        new SpriteStaticMapper("bush4", scale, 9),
        new SpriteStaticMapper("bush5", scale, 10),
        new SpriteStaticMapper("bush6", scale, 11),
        new SpriteStaticMapper("stump2", scale, 12),
        new SpriteStaticMapper("stump3", scale, 13),
        new SpriteStaticMapper("stump4", scale, 14),
        new SpriteStaticMapper("stump5", scale, 15),

        new SpriteStaticMapper("tree1t", scale, 16),
        new SpriteStaticMapper("tree1b", scale, 24),

        new SpriteStaticMapper("dt1t", scale, 18),
        new SpriteStaticMapper("dt1b", scale, 26),

        new SpriteBatchMapper("bt1", 1, new int[]{22, 23, 30, 31}, 2)
    };
  }

  @Override
  public Sprite getDefaultSprite() {
    return getSprite("grass1");
  }

  @Override
  public String getPackageName() {
    return "n1";
  }

}
