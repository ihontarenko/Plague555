package org.nullapp.gameCore.gfx.sprite;

import java.util.HashMap;
import java.util.Map;

public class SpriteFont {

  private Map<Integer, Sprite> sprites;
  private Integer              fontScale;

  public SpriteFont(SpriteSheet spriteSheet, SpriteFontMap spriteFontMap) {
    this.sprites = new HashMap<>(spriteSheet.count());
    mapSprites(spriteSheet, spriteFontMap);
  }

  private void mapSprites(SpriteSheet spriteSheet, SpriteFontMap spriteFontMap) {
    for (int charCode : spriteFontMap.getChars()) {
      this.sprites.put(charCode, spriteSheet.getSprite(spriteFontMap.getPosition(charCode)));
    }
  }

  public Sprite getSprite(int position) {
    return sprites.get(position);
  }

  public Integer getFontScale() {
    return fontScale;
  }

  public void setFontScale(Integer fontScale) {
    this.fontScale = fontScale;
  }

}
