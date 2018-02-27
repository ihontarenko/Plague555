package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.controller.MenuController;
import org.plagueinc.sorrowland.core.controller.ControllerContainer;
import org.plagueinc.sorrowland.core.controller.ControllerInterface;
import org.plagueinc.sorrowland.core.entity.Loop;
import org.plagueinc.sorrowland.core.renderer.RendererContainer;
import org.plagueinc.sorrowland.gui.GUIWindow;

public class GameLoop extends Loop {

  private boolean             isInitialized;
  private float               oneSecondElapsed;
  private GUIWindow           gui;
  private ControllerInterface activeController;
  private ControllerContainer controllerContainer;
  private RendererContainer   rendererContainer;

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

      controllerContainer = new ControllerContainer();
      rendererContainer = new RendererContainer();

      activeController = controllerContainer.getObject(MenuController.class);

      System.out.println(activeController);

      isInitialized = true;
    }
  }

  @Override
  protected void update(float elapsedTime) {
    oneSecondElapsed += elapsedTime;

    if (oneSecondElapsed > (ONE_NANO_SECOND / 4)) {
      gui.setTitle(getExecutionInfo());
      oneSecondElapsed = 0;
    }

    activeController.update(elapsedTime);
  }

  @Override
  protected void render() {
    gui.clearFrame();
    activeController.draw(gui.getG2D());
    gui.swapBuffer();
  }
}
