package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup.SpriteAnimatedSetup;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup.SpriteSetup;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup.SpriteStaticSetup;

import java.util.HashMap;
import java.util.Map;

abstract public class SpritePackage implements Initializable {

  private SpriteSheet         spriteSheet;
  private Map<String, Sprite> sprites;

  public SpritePackage(SpriteSheet spriteSheet) {
    this.spriteSheet = spriteSheet;
    this.sprites = new HashMap<>();
    initialize();
  }

  public Map<String, Sprite> getSprites() {
    return sprites;
  }

  public Sprite getSprite(String name) {
    return sprites.get(name);
  }

  public String getPackageUniqueName() {
    return getClass().getSimpleName();
  }

  @Override
  public boolean isInitialized() {
    return sprites.size() > 0;
  }

  @Override
  public void initialize() {
    for (SpriteSetup setup : getSpriteSetup()) {
      Sprite sprite;

      if (setup instanceof SpriteAnimatedSetup) {
        sprite = createSprite((SpriteAnimatedSetup) setup);
      } else {
        sprite = createSprite((SpriteStaticSetup) setup);
      }

      sprites.put(setup.getName(), sprite);
    }
  }

  private Sprite createSprite(SpriteAnimatedSetup setup) {
    return new SpriteAnimated(spriteSheet,
        setup.getFps(), setup.getScale(), setup.getStart(), setup.getEnd(), setup.getDirection());
  }

  private Sprite createSprite(SpriteStaticSetup setup) {
    return new SpriteStatic(spriteSheet, setup.getScale(), setup.getPosition());
  }

  @Override
  public void reinitialize() {
  }

  abstract public SpriteSetup[] getSpriteSetup();

}
