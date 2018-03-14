package com.nullion.sorrowland.app;

import com.nullion.sorrowland.app.config.AppConfiguration;
import com.nullion.sorrowland.app.gfx.font.BoxySpriteFontMap;
import com.nullion.appcore.gfx.StringDrawer;
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

      AppContext appContext = new AppContext();
      AppConfiguration appConfiguration;

      appContext.registerService(AppContext.CONFIG_OBJECT, AppConfiguration.class, "config/app.properties");
      appContext.getConfiguration().initialize();

      appConfiguration = (AppConfiguration) appContext.getConfiguration();

      InputKey  inputKey = new InputKey();
      GUIWindow gui      = new GUIWindow(appConfiguration.getWidth(), appConfiguration.getHeight(), getClass().getSimpleName());

      gui.initialize();
      gui.getMainFrame().add(inputKey);

      appContext.registerService(AppContext.STRING_DRAWER, StringDrawer.class, new BoxySpriteFontMap());

      appContext.setGuiWindow(gui);
      appContext.setInputKey(inputKey);
      appContext.setAppManager(new AppManager(appContext));

      appContext.setLoop(this);

      this.appContext = appContext;

      gui.setTitlePrefix(appConfiguration.getAppFullName());

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
