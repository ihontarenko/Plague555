package org.nulllab.sorrowland.app;

import org.nulllab.nullengine.core.common.resource.ImageLoader;
import org.nulllab.nullengine.core.graphics.sprite.SpriteFont;
import org.nulllab.nullengine.core.graphics.sprite.SpriteSheet;
import org.nulllab.sorrowland.app.config.AppConfiguration;
import org.nulllab.sorrowland.app.gfx.font.BoxySpriteFontMap;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.core.loop.Loop;
import org.nulllab.ui.service.AppContext;
import org.nulllab.ui.service.AppContextAware;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

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

      Keyboard  inputKey = new Keyboard();
      GUIWindow gui      = new GUIWindow(appConfiguration.getWidth(), appConfiguration.getHeight(), getClass().getSimpleName());

      gui.initialize();
      gui.getMainFrame().add(inputKey);

      SpriteSheet spriteSheet = null;
      InputStream inputStream = new ImageLoader("ui/fonts/boxy.png").getFileStream();

      try {
        spriteSheet = new SpriteSheet(ImageIO.read(inputStream), 18, 16);
      } catch (IOException e) {
        e.printStackTrace();
      }

      appContext.registerService(AppContext.STRING_DRAWER, StringDrawer.class, new SpriteFont(spriteSheet, new BoxySpriteFontMap()));

      appContext.setGuiWindow(gui);
      appContext.setInputKey(inputKey);
      appContext.setAppManager(new Manager(appContext));

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
    GUIWindow window  = getGuiWindow();
    Manager   manager = (Manager) getAppManager();

    window.setTitle(getExecutionInfo());
    manager.update(elapsed);

    // custom code below
    //
  }

  @Override
  protected void render() {
    GUIWindow window  = getGuiWindow();
    Manager   manager = (Manager) getAppManager();

    window.clearFrame();
    manager.render(window.getG2D());
    window.swapBuffer();
  }

  @Override
  public AppContext getContext() {
    return appContext;
  }

}
