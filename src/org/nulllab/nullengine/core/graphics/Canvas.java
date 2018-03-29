package org.nulllab.nullengine.core.graphics;

import java.awt.image.BufferedImage;

public interface Canvas {

  void drawImage(BufferedImage image, double x, double y, int width, int height);

  void drawRectangle(int x, int y, int width, int height);

  void drawFilledRectangle(int x, int y, int width, int height);

  void drawOval(int x, int y, int width, int height);

  void drawFilledOval(int x, int y, int width, int height);

  void setColor(String hexColor);

  void setColor(int argb);

  void setColor(int red, int green, int blue);

  void setColor(int red, int green, int blue, int alpha);

  default void drawRectangle(double x, double y, int width, int height) {
    drawRectangle((int)x, (int)y, width, height);
  }

}
