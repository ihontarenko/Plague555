package org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack;

import org.nulllab.nullengine.core.graphics.GraphicsPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteAnimated;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteBatch;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteStatic;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteAnimatedMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteBatchMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.mapping.SpriteStaticMapper;
import org.nulllab.nullengine.openworld.ServiceLocator;

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

        switch (mapper.getClass().getSimpleName()) {
          case "SpriteAnimatedMapper":
            sprite = createSprite(spriteSheet, (SpriteAnimatedMapper) mapper);
            break;
          case "SpriteStaticMapper":
            sprite = createSprite(spriteSheet, (SpriteStaticMapper) mapper);
            break;
          case "SpriteBatchMapper":
            sprite = createSprite(spriteSheet, (SpriteBatchMapper) mapper);
            sprite.setScale(mapper.getScale());
            break;
          default:
            sprite = createSprite(spriteSheet, (SpriteStaticMapper) mapper);
        }

        if (mapper.getColorRemove() > -1) sprite.setOpacity(mapper.getColorRemove(), 1F);

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

  private Sprite createSprite(SpriteSheet sheet, SpriteBatchMapper setup) {
    return new SpriteBatch(sheet.getBufferedImages(setup.getPositions()), setup.getCountInWidth());
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
