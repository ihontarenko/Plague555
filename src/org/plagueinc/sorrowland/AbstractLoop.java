package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.core.controller.ControllerContainer;
import org.plagueinc.sorrowland.core.controller.ControllerInterface;
import org.plagueinc.sorrowland.core.entity.Loop;
import org.plagueinc.sorrowland.core.renderer.RendererContainer;
import org.plagueinc.sorrowland.gui.GUIWindow;

abstract public class AbstractLoop extends Loop {

  boolean isInitialized;
  private float               oneSecondElapsed;
  private GUIWindow           gui;
  private ControllerInterface activeController;
  private ControllerContainer controllerContainer;
  private RendererContainer   rendererContainer;

  public AbstractLoop() {
    super();

    controllerContainer = new ControllerContainer();
    rendererContainer = new RendererContainer();

    initialize();
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  protected void update(float elapsedTime) {
    oneSecondElapsed += elapsedTime;

    if (oneSecondElapsed > (ONE_NANO_SECOND / 4)) {
      gui.setTitle(getExecutionInfo());
      oneSecondElapsed = 0;
    }

    getActiveController().update(elapsedTime);
  }

  @Override
  protected void render() {
    getGui().clearFrame();
    activeController.draw(getGui().getG2D());
    getGui().swapBuffer();
  }

  public ControllerInterface getActiveController() {
    return activeController;
  }

  public void setActiveController(ControllerInterface activeController) {
    this.activeController = activeController;
  }

  public GUIWindow getGui() {
    return gui;
  }

  public void setGui(GUIWindow gui) {
    this.gui = gui;
  }

  public ControllerContainer getControllerContainer() {
    return controllerContainer;
  }

  public RendererContainer getRendererContainer() {
    return rendererContainer;
  }

}
