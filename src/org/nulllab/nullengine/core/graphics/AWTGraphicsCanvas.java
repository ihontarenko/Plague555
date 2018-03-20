package org.nulllab.nullengine.core.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AWTGraphicsCanvas extends Canvas {

  private Graphics2D graphics;

  public AWTGraphicsCanvas(Graphics2D graphics) {
    this.graphics = graphics;
  }

  public void drawImage(BufferedImage image, int x, int y, int width, int height) {
    graphics.drawImage(image, x, y, width, height, null);
  }

}
