package com.nullion.sorrowland.app;

import com.nullion.sorrowland.app.manager.AppManager;
import com.nullion.appcore.gui.GUIWindow;
import com.nullion.appcore.io.InputKey;
import com.nullion.appcore.loop.Loop;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.service.AppContextAware;

public class GameLoop extends Loop implements AppContextAware {

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

      InputKey  inputKey = new InputKey();
      GUIWindow gui      = new GUIWindow(800, 600, getClass().getSimpleName());

      gui.initialize();
      gui.getMainFrame().add(inputKey);

      appContext = new AppContext();

      appContext.setGuiWindow(gui);
      appContext.setInputKey(inputKey);
      appContext.setAppManager(new AppManager(appContext));

      appContext.setLoop(this);

      isInitialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

  @Override
  protected void update(float elapsed) {
    // default code for update window title information
    GUIWindow window = getGuiWindow();
    AppManager appManager = (AppManager) getAppManager();

    window.setTitle(getExecutionInfo());
    appManager.update(elapsed);

    // custom code below
    //
  }

  @Override
  protected void render() {
    GUIWindow window = getGuiWindow();
    AppManager appManager = (AppManager) getAppManager();

    window.clearFrame();
    appManager.render(window.getG2D());
    window.swapBuffer();
  }

  @Override
  public AppContext getContext() {
    return appContext;
  }

}
