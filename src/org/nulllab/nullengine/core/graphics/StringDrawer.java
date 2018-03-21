package org.nulllab.nullengine.core.graphics;

import org.nulllab.nullengine.core.graphics.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.sprite.SpriteFont;

import java.awt.*;

public class StringDrawer implements Drawable<Canvas> {

  private SpriteFont spriteFont;
  private String     string;

  public StringDrawer(SpriteFont spriteFont) {
    this.spriteFont = spriteFont;
  }

  public void draw(Canvas g2d, String string, int x, int y) {
    setString(string);
    draw(g2d, x, y);
  }

  @Override
  public void draw(Canvas g2d, int x, int y) {
    String string  = getString();
    int    offsetX;

    for (int i = 0; i < string.length(); i++) {
      Sprite sprite = spriteFont.getSprite(string.charAt(i));
      offsetX = (i * sprite.getWidth());
      sprite.draw(g2d, x + offsetX, y);
    }
  }

  public SpriteFont getSpriteFont() {
    return spriteFont;
  }

  public void setSpriteFont(SpriteFont spriteFont) {
    this.spriteFont = spriteFont;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

}
