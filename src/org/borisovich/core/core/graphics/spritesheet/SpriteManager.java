package org.borisovich.core.core.graphics.spritesheet;

import org.borisovich.core.core.container.ObjectManager;
import org.borisovich.core.core.graphics.GraphicsPackage;
import org.borisovich.core.core.graphics.spritesheet.sheet.SpriteSheet;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;
import org.borisovich.core.core.graphics.spritesheet.sprite.Sprite;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.SpritePackage;

import java.util.Arrays;
import java.util.List;

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
    List<String> idParts = getIDParts(id);

    return getSheetFromPackage(idParts.get(0), idParts.get(1));
  }

  public Sprite getSpriteFromPackage(String id) {
    List<String> idParts = getIDParts(id);

    return getSpriteFromPackage(idParts.get(0), idParts.get(1));
  }

  public static List<String> getIDParts(String id, String separator) {
    return Arrays.asList(id.split(separator));
  }

  public static List<String> getIDParts(String id) {
    return getIDParts(id, "\\.");
  }

}
