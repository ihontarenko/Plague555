package org.plagueinc.sorrowland.controller;

import org.plagueinc.sorrowland.core.controller.ControllerInterface;

import java.awt.*;

public class MenuController implements ControllerInterface {

  @Override
  public void update(float nanoSeconds) {

  }

  @Override
  public void draw(Graphics2D g2d) {
    g2d.setColor(Color.RED);
    g2d.drawOval(10, 10, 100, 100);
  }

}
