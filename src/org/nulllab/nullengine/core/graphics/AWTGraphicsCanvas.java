package org.nulllab.nullengine.core.graphics;

import sun.java2d.SunGraphics2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AWTGraphicsCanvas implements Canvas {

  private Graphics2D graphics;

  public AWTGraphicsCanvas(SunGraphics2D graphics) {
    this.graphics = graphics;
  }

  @Override
  public void drawImage(BufferedImage image, double x, double y, int width, int height) {
    graphics.drawImage(image, (int)x, (int)y, width, height, null);
  }

  @Override
  public void drawRectangle(int x, int y, int width, int height) {
    graphics.drawRect(x, y, width, height);
  }

  @Override
  public void drawFilledRectangle(int x, int y, int width, int height) {
    graphics.fillRect(x, y, width, height);
  }

  @Override
  public void drawOval(int x, int y, int width, int height) {
    graphics.drawOval(x, y, width, height);
  }

  @Override
  public void drawFilledOval(int x, int y, int width, int height) {
    graphics.fillOval(x, y, width, height);
  }

  @Override
  public void setColor(String hexColor) {
    graphics.setColor(Color.decode(hexColor));
  }

  @Override
  public void setColor(int argb) {
    graphics.setColor(new Color(argb));
  }

  @Override
  public void setColor(int red, int green, int blue) {
    graphics.setColor(new Color(red, green, blue));
  }

  @Override
  public void setColor(int red, int green, int blue, int alpha) {
    graphics.setColor(new Color(red, green, blue, alpha));
  }
}
