package org.plagueinc.sorrowland.editor.controller;

import org.plagueinc.sorrowland.core.controller.ControllerInterface;

import java.awt.*;

public class EditorController implements ControllerInterface {

  @Override
  public void update(float nanoSeconds) {

  }

  @Override
  public void draw(Graphics2D g2d) {
    g2d.drawRect(10, 10, 20, 20);
  }

}
