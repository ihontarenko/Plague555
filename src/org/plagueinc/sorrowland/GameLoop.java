package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.controller.GameControllerInterface;
import org.plagueinc.sorrowland.controller.MenuController;
import org.plagueinc.sorrowland.controller.Window1Controller;
import org.plagueinc.sorrowland.core.entity.Loop;
import org.plagueinc.sorrowland.gui.GUIFrame;
import org.plagueinc.sorrowland.gui.GUIWindow;
import org.plagueinc.sorrowland.gui.canvas.GUICanvas;
import org.plagueinc.sorrowland.gui.pane.MainMenuPane;

import javax.swing.*;
import java.awt.*;

public class GameLoop extends Loop {

  private boolean isInitialized    = false;
  private float   oneSecondElapsed = 0;
  private GUIWindow               gui;
  private GameControllerInterface controller;

  public GameLoop() {
    super();
    initialize();
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      gui = new GUIWindow(800, 600);
      gui.initialize();
      controller = new MenuController();

      GUICanvas canvas = new GUICanvas(400, 300);
      canvas.setDefaultColor(0xFF72A0C1);

      gui.getMainFrame().add(new MainMenuPane(), BorderLayout.SOUTH);
      gui.getMainFrame().updateUI();

      gui.getMainFrame().addCanvas("canvas1", canvas);

      GUICanvas canvas2 = new GUICanvas(300, 200);
      canvas.setDefaultColor(0xFFE32636);

      gui.getMainFrame().addCanvas("canvas2", canvas2);

      isInitialized = true;
    }
  }

  @Override
  protected void update(float elapsedTime) {
    oneSecondElapsed += elapsedTime;
    if (oneSecondElapsed > (ONE_NANO_SECOND / 4)) {
      gui.appendTitle(getExecutionInfo());
      oneSecondElapsed = 0;
//
//      GUIFrame frame = gui.getMainFrame();
//
//      MainMenuPane pane = new MainMenuPane();
//
//      frame.add(pane, BorderLayout.SOUTH);
//      frame.updateUI();
//
//      pane.getStartButton().addActionListener(e -> {
//        if (controller instanceof MenuController) {
//          controller = new Window1Controller();
//        } else {
//          controller = new MenuController();
//        }
//      });

    }
    controller.update(elapsedTime);
  }

  @Override
  protected void render() {
    gui.clearFrame();

//    controller.draw(gui.getMainCanvas().getG2D());

    gui.swapBuffer();
  }
}
