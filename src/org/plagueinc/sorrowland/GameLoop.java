package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.controller.GameControllerInterface;
import org.plagueinc.sorrowland.controller.MenuController;
import org.plagueinc.sorrowland.controller.Window1Controller;
import org.plagueinc.sorrowland.core.entity.Loop;
import org.plagueinc.sorrowland.gui.GUIFrame;
import org.plagueinc.sorrowland.gui.GUIWindow;
import org.plagueinc.sorrowland.gui.pane.MainMenuPane;

import java.awt.*;

public class GameLoop extends Loop {

  private boolean isInitialized    = false;
  private float   oneSecondElapsed = 0;
  private GUIWindow               gui;
  private GameControllerInterface controller;

  public GameLoop() {
    super();
    initialize();
    controller = new MenuController();
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
      isInitialized = true;
    }
  }

  @Override
  protected void update(float elapsedTime) {
    oneSecondElapsed += elapsedTime;
    if (oneSecondElapsed > ONE_NANO_SECOND) {
      gui.appendTitle(getExecutionInfo());
      oneSecondElapsed = 0;

      GUIFrame frame = gui.getMainFrame();

      MainMenuPane pane = new MainMenuPane();

      frame.add(pane, BorderLayout.SOUTH);
      frame.updateUI();

      pane.getStartButton().addActionListener(e -> {
        if (controller instanceof MenuController) {
          controller = new Window1Controller();
        } else {
          controller = new MenuController();
        }
      });

    }
    controller.update(elapsedTime);
  }

  @Override
  protected void render() {
    gui.clearFrame();

    controller.draw(gui.getGraphics2D());

    gui.swapBuffer();
  }
}
