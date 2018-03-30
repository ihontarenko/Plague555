package org.nulllab.nullengine.core.graphics.spritesheet;

import org.nulllab.nullengine.core.container.ObjectManager;
import org.nulllab.nullengine.core.graphics.GraphicsPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;

@SuppressWarnings("unused")
public class SpriteManager extends ObjectManager<GraphicsPackage> {

  public SpriteManager() {
  }

  public void addSheetPackage(String name, Class<? extends GraphicsPackage> packageClass) {
    registerService(name, packageClass);
  }

  public void addSheetPackage(SpriteSheetPackage sheetPackage) {
    setObject(sheetPackage.getPackageName(), sheetPackage);
  }

  public SpriteSheetPackage getSheetPackage(String packageClassName) {
    return (SpriteSheetPackage) getObject(packageClassName);
  }

  public SpriteSheet getSheetFromPackage(String packageName, String sheetName) {
    return getSheetPackage(packageName).getSpriteSheet(sheetName);
  }

  public SpriteSheet getSheetFromPackage(String id) {
    String[] sheetID     = id.split(".");
    String   packageName = sheetID[0];
    String   sheetName   = sheetID[1];

    return getSheetFromPackage(packageName, sheetName);
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
