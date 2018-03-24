package org.nulllab.nullengine.core.graphics.spritesheet;

import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteStatic;

import java.util.HashMap;
import java.util.Map;

public class SpriteFont {

  private Map<Integer, SpriteStatic> sprites;
  private double                     fontScale;

  public SpriteFont(SpriteSheet spriteSheet, SpriteFontMap spriteFontMap) {
    this(spriteSheet, spriteFontMap, 1D);
  }

  public SpriteFont(SpriteSheet spriteSheet, SpriteFontMap spriteFontMap, double scale) {
    this.sprites = new HashMap<>(spriteSheet.count());
    setFontScale(scale);
    mapSprites(spriteSheet, spriteFontMap);
  }

  private void mapSprites(SpriteSheet spriteSheet, SpriteFontMap spriteFontMap) {
    for (int charCode : spriteFontMap.getChars()) {
      SpriteStatic sprite = spriteSheet.getSprite(spriteFontMap.getPosition(charCode));
      sprite.setScale(getFontScale());
      this.sprites.put(charCode, sprite);
    }
  }

  public double getFontScale() {
    return fontScale;
  }

  public void setFontScale(double fontScale) {
    this.fontScale = fontScale;
  }

  public SpriteStatic getSprite(int position) {
    return sprites.get(position);
  }

}
