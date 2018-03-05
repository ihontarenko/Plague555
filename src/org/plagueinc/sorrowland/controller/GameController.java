package org.plagueinc.sorrowland.controller;

import org.plagueinc.sorrowland.core.controller.AbstractController;

import java.awt.*;

public class GameController extends AbstractController {

  @Override
  public void update(float nanoSeconds) {

  }

  @Override
  public void draw(Graphics2D g2d) {
    g2d.setColor(Color.BLUE);
    g2d.drawRect(10, 10, 100, 100);
  }

}
