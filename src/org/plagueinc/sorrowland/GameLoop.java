package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.core.entity.Loop;
import org.plagueinc.sorrowland.gui.GUIWindow;
import org.plagueinc.sorrowland.manager.AppManager;
import org.plagueinc.sorrowland.service.AppContext;

public class GameLoop extends Loop {

  private boolean    isInitialized;
  private float      oneSecondElapsed;
  private AppContext appContext;

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

      GUIWindow guiWindow = new GUIWindow(800, 600);
      guiWindow.initialize();

      appContext = new AppContext();

      appContext.setGuiWindow(guiWindow);
      appContext.setAppManager(new AppManager(appContext));

      isInitialized = true;
    }
  }

  @Override
  protected void update(float nano) {
    // default code for update window title information
    oneSecondElapsed += nano;
    if (oneSecondElapsed > (ONE_NANO_SECOND / 4) && null != getExecutionInfo()) {
      getGUI().setTitle(getExecutionInfo());
      oneSecondElapsed = 0;
    }

    // custom code below
    getAppManager().update(nano);
  }

  @Override
  protected void render() {
    getGUI().clearFrame();
    getAppManager().render(getGUI().getG2D());
    getGUI().swapBuffer();
  }

  public AppManager getAppManager() {
    return getAppContext().getAppManager();
  }

  public GUIWindow getGUI() {
    return getAppContext().getGuiWindow();
  }

  public AppContext getAppContext() {
    return appContext;
  }

}
