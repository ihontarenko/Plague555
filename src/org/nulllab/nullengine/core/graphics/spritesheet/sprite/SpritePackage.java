package org.nulllab.nullengine.core.graphics.spritesheet.sprite;

import org.nulllab.nullengine.core.ServiceLocator;
import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteAnimatedMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteMapper;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.mapping.SpriteStaticMapper;

import java.util.HashMap;
import java.util.Map;

abstract public class SpritePackage implements Initializable {

  private Map<String, Sprite>                 sprites;
  private Class<? extends SpriteSheetPackage> packageClass;
  private String                              sheetName;

  public SpritePackage(Class<? extends SpriteSheetPackage> packageClass, String sheetName) {
    this.sprites = new HashMap<>();
    this.packageClass = packageClass;
    this.sheetName = sheetName;
    initialize();
  }

  public Map<String, Sprite> getSprites() {
    return sprites;
  }

  public Sprite getSprite(String name) {
    return sprites.get(name);
  }

  public Class<? extends SpriteSheetPackage> getPackageClass() {
    return packageClass;
  }

  public String getSheetName() {
    return sheetName;
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
    SpriteSheet spriteSheet = findSpriteSheet();

    for (SpriteMapper mapper : getSpriteMappers()) {
      Sprite sprite;

      if (mapper instanceof SpriteAnimatedMapper) {
        sprite = createSprite(spriteSheet, (SpriteAnimatedMapper) mapper);
      } else {
        sprite = createSprite(spriteSheet, (SpriteStaticMapper) mapper);
      }

      sprites.put(mapper.getName(), sprite);
    }
  }

  private Sprite createSprite(SpriteSheet sheet, SpriteAnimatedMapper setup) {
    return new SpriteAnimated(sheet, setup.getFps(), setup.getScale(), setup.getStart(), setup.getEnd(), setup.getDirection());
  }

  private Sprite createSprite(SpriteSheet sheet, SpriteStaticMapper setup) {
    return new SpriteStatic(sheet, setup.getScale(), setup.getPosition());
  }

  private SpriteSheet findSpriteSheet() {
    SpriteManager spriteManager = ServiceLocator.getInstance().getSpriteManager();

    return spriteManager.getSheetFromPackage(getPackageClass(), getSheetName());
  }

  @Override
  public void reinitialize() {
  }

  abstract public SpriteMapper[] getSpriteMappers();

}
