package org.nulllab.nullengine.core.graphics.sprite;

import java.util.HashMap;
import java.util.Map;

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

  public SpriteSheet getSheetFromPackage(Class<? extends SpriteSheetPackage> packageClass, Integer index) {
    return getSheetFromPackage(packageClass.getSimpleName(), index);
  }

  public SpriteSheet getSheetFromPackage(String packageClassName, Integer index) {
    return getSheetPackage(packageClassName).getSpriteSheet(index);
  }

}
