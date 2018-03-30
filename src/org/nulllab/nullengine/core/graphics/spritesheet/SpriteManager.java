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

  public void addSheetPackage(SpriteSheetPackage sheetPackage) {
    setObject(sheetPackage.getPackageName(), sheetPackage);
  }

  public SpriteSheetPackage getSheetPackage(String name) {
    return (SpriteSheetPackage) getObject(name);
  }

  public SpriteSheet getSheetFromPackage(String packageName, String sheetName) {
    return getSheetPackage(packageName).getSpriteSheet(sheetName);
  }

  public void addSpritePackage(SpritePackage spritePackage) {
    setObject(spritePackage.getPackageName(), spritePackage);
  }

  public SpritePackage getSpritePackage(String name) {
    return (SpritePackage) getObject(name);
  }

  public Sprite getSpriteFromPackage(String packageName, String name) {
    return getSpritePackage(packageName).getSprite(name);
  }

  public SpriteSheet getSheetFromPackage(String id) {
    String[] sheetID     = id.split("\\.");

    return getSheetFromPackage(sheetID[0], sheetID[1]);
  }

  public Sprite getSpriteFromPackage(String id) {
    String[] spriteID     = id.split("\\.");

    return getSpriteFromPackage(spriteID[0], spriteID[1]);
  }

}
