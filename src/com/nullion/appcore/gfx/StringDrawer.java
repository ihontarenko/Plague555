package com.nullion.appcore.gfx;

import com.nullion.appcore.common.Drawable;
import com.nullion.appcore.gfx.sprite.SpriteFont;

import java.awt.*;

public class StringDrawer implements Drawable {

  private SpriteFont spriteFont;
  private String     string;

  public StringDrawer(SpriteFont spriteFont) {
    this.spriteFont = spriteFont;
  }

  public void draw(Graphics2D g2d, String string, int x, int y) {
    setString(string);
    draw(g2d, x, y);
  }

  @Override
  public void draw(Graphics2D g2d, int x, int y) {
    String string = getString();

    for (int i = 0; i < string.length(); i++) {
//      spriteFont.getSprite()
    }

    setString(null);
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
