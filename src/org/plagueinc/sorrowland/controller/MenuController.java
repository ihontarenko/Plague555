package org.plagueinc.sorrowland.controller;

import java.awt.*;

public class MenuController implements GameControllerInterface {

  @Override
  public void update(float nanoSeconds) {

  }

  @Override
  public void draw(Graphics2D g2d) {
    g2d.setColor(Color.RED);
    g2d.drawRect(10, 10, 100, 100);
  }

}
