package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.core.graphics.GraphicsPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteAnimatedMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteStaticMapper;

import java.util.HashMap;
import java.util.Map;

abstract public class SpritePackage implements GraphicsPackage {

  private Map<String, Sprite> sprites;
  private String              sheetID;

  public SpritePackage(String sheetID) {
    this.sprites = new HashMap<>();
    this.sheetID = sheetID;
    initialize();
  }

  public Map<String, Sprite> getSprites() {
    return sprites;
  }

  public Sprite getSprite(String name) {
    return sprites.get(name);
  }

  public String getSheetID() {
    return sheetID;
  }

  @Override
  public boolean isInitialized() {
    return sprites.size() > 0;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      SpriteSheet spriteSheet = findSpriteSheet();

      for (SpriteMapper mapper : getSpriteMappers()) {
        Sprite sprite;

        if (mapper instanceof SpriteAnimatedMapper) {
          sprite = createSprite(spriteSheet, (SpriteAnimatedMapper) mapper);
        } else {
          sprite = createSprite(spriteSheet, (SpriteStaticMapper) mapper);
        }

        if (mapper.getColorRemove() > -1) {
          sprite.setOpacity(mapper.getColorRemove(), 1F);
        }

        sprites.put(mapper.getName(), sprite);
      }
    }
  }

  private Sprite createSprite(SpriteSheet sheet, SpriteAnimatedMapper setup) {
    return new SpriteAnimated(sheet, setup.getFps(), setup.getScale(), setup.getStart(), setup.getEnd(), setup.getLoopType());
  }

  private Sprite createSprite(SpriteSheet sheet, SpriteStaticMapper setup) {
    return new SpriteStatic(sheet, setup.getScale(), setup.getPosition());
  }

  private SpriteSheet findSpriteSheet() {
    SpriteManager spriteManager = ServiceLocator.getInstance().getSpriteManager();

    return spriteManager.getSheetFromPackage(getSheetID());
  }

  @Override
  public void reinitialize() {
  }

  abstract public SpriteMapper[] getSpriteMappers();

  abstract public Sprite getDefaultSprite();

}
