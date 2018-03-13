package org.nullapp.sorrowland.app;

import org.nullapp.sorrowland.app.gui.GUIWindow;
import org.nullapp.sorrowland.app.manager.AppManager;
import org.nullapp.sorrowland.app.service.AppContext;
import org.nullapp.sorrowland.core.loop.Loop;

public class GameLoop extends Loop {

  private boolean    isInitialized;
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

      appContext.setLoop(this);

      isInitialized = true;
    }
  }

  @Override
  protected void update(float elapsed) {
    // default code for update window title information
    getGUI().setTitle(getExecutionInfo());

    // custom code below
    getAppManager().update(elapsed);
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
