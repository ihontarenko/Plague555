package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.core.entity.Loop;
import org.plagueinc.sorrowland.core.state.AbstractStateManager;
import org.plagueinc.sorrowland.gui.GUIWindow;

public class GameLoop extends Loop {

  private boolean              isInitialized;
  private float                oneSecondElapsed;
  private GUIWindow            gui;
  private AbstractStateManager stateManager;

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
      isInitialized = true;
      gui = new GUIWindow(800, 600);
      gui.initialize();
      stateManager = new AbstractStateManager() { };
    }
  }

  @Override
  protected void update(float elapsedTime) {
    // default code for update window title information
    oneSecondElapsed += elapsedTime;
    if (oneSecondElapsed > (ONE_NANO_SECOND / 4) && null != getExecutionInfo()) {
      gui.setTitle(getExecutionInfo());
      oneSecondElapsed = 0;
    }

    // custom code below
  }

  @Override
  protected void render() {
    gui.clearFrame();
//    .draw(gui.getG2D());
    gui.swapBuffer();
  }

  public AbstractStateManager getStateManager() {
    return stateManager;
  }

}
