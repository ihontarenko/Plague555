package org.nulllab.nullengine.core.graphics;

import java.awt.image.BufferedImage;

public interface Canvas {

  void drawImage(BufferedImage image, int x, int y, int width, int height);

  void drawRectangle(int x, int y, int width, int height);

  void drawOval(int x, int y, int width, int height);

  void setColor(String hexColor);

  void setColor(int argb);

  void setColor(int red, int green, int blue);

  void setColor(int red, int green, int blue, int alpha);

}
