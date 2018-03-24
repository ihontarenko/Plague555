package org.nulllab.nullengine.core.graphics.spritesheet;

import org.nulllab.nullengine.core.container.ObjectManager;
import org.nulllab.nullengine.core.graphics.GraphicsPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class SpriteManager extends ObjectManager<GraphicsPackage> {

  private Map<String, SpriteSheetPackage> sheetPackageMap;
  private Map<String, SpritePackage>      spritePackageMap;

  public SpriteManager() {
    sheetPackageMap = new HashMap<>();
  }

  public void addSheetPackage(Class<? extends GraphicsPackage> packageClass) {
    registerService(packageClass.getSimpleName(), packageClass);
  }

  public void addSheetPackage(SpriteSheetPackage sheetPackage) {
    setObject(sheetPackage.getClass().getSimpleName(), sheetPackage);
  }

  public SpriteSheetPackage getSheetPackage(Class<? extends SpriteSheetPackage> packageClass) {
    return getSheetPackage(packageClass.getSimpleName());
  }

  public SpriteSheetPackage getSheetPackage(String packageClassName) {
    return (SpriteSheetPackage) getObject(packageClassName);
  }

  public SpriteSheet getSheetFromPackage(Class<? extends SpriteSheetPackage> packageClass, String name) {
    return getSheetFromPackage(packageClass.getSimpleName(), name);
  }

  public SpriteSheet getSheetFromPackage(String packageClassName, String name) {
    return getSheetPackage(packageClassName).getSpriteSheet(name);
  }

  public void addSpritePackage(Class<? extends GraphicsPackage> packageClass) {
    registerService(packageClass.getSimpleName(), packageClass);
  }

  public void addSpritePackage(SpritePackage spritePackage) {
    setObject(spritePackage.getClass().getSimpleName(), spritePackage);
  }

  public SpritePackage getSpritePackage(Class<? extends SpritePackage> packageClass) {
    return getSpritePackage(packageClass.getSimpleName());
  }

  public SpritePackage getSpritePackage(String packageClassName) {
    return (SpritePackage) getObject(packageClassName);
  }

  public Sprite getSpriteFromPackage(Class<? extends SpritePackage> packageClass, String name) {
    return getSpriteFromPackage(packageClass.getSimpleName(), name);
  }

  public Sprite getSpriteFromPackage(String packageClassName, String name) {
    return getSpritePackage(packageClassName).getSprite(name);
  }

}
