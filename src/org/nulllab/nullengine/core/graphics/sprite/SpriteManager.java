package org.nulllab.nullengine.core.graphics.sprite;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class SpriteManager {

  private Map<String, SpriteSheetPackage> sheetPackageMap;

  public SpriteManager() {
    sheetPackageMap = new HashMap<>();
  }

  public void addSheetPackage(SpriteSheetPackage sheetPackage) {
    sheetPackageMap.put(sheetPackage.getPackageUniqueName(), sheetPackage);
  }

  public SpriteSheetPackage getSheetPackage(Class<? extends SpriteSheetPackage> packageClass) {
    return getSheetPackage(packageClass.getSimpleName());
  }

  public SpriteSheetPackage getSheetPackage(String packageClassName) {
    return sheetPackageMap.get(packageClassName);
  }

  public SpriteSheet getSheetFromPackage(Class<? extends SpriteSheetPackage> packageClass, String name) {
    return getSheetFromPackage(packageClass.getSimpleName(), name);
  }

  public SpriteSheet getSheetFromPackage(String packageClassName, String name) {
    return getSheetPackage(packageClassName).getSpriteSheet(name);
  }

}