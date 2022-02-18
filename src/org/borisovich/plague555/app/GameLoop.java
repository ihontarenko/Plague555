package org.borisovich.plague555.app;

import org.borisovich.core.core.common.resource.ImageLoader;
import org.borisovich.core.core.graphics.AWTGraphicsCanvas;
import org.borisovich.core.core.graphics.spritesheet.SpriteFont;
import org.borisovich.core.core.graphics.spritesheet.sheet.SpriteSheet;
import org.borisovich.core.core.graphics.spritesheet.sheet.pack.SpriteSheetPackage;
import org.borisovich.plague555.app.config.Configuration;
import org.borisovich.plague555.app.graphics.DefaultFontMap;
import org.borisovich.plague555.app.graphics.sheet.DefaultFontSheetPackage;
import org.borisovich.plague555.app.manager.Manager;
import org.borisovich.core.core.graphics.StringDrawer;
import org.borisovich.ui.gui.GUIWindow;
import org.borisovich.core.core.input.Keyboard;
import org.borisovich.core.core.loop.Loop;
import org.borisovich.ui.service.Context;
import org.borisovich.ui.service.ContextAware;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class GameLoop extends Loop implements ContextAware {

  private boolean isInitialized;
  private Context context;

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

      Context       context = new Context();
      Configuration configuration;

      context.registerService(Context.CONFIG_OBJECT, Configuration.class, "config/app.properties");
      context.getConfiguration().initialize();

      configuration = (Configuration) context.getConfiguration();

      Keyboard  inputKey = new Keyboard();
      GUIWindow gui      = new GUIWindow(configuration.getWidth(), configuration.getHeight(), getClass().getSimpleName());

      gui.initialize();
      gui.getMainFrame().add(inputKey);

      SpriteSheet spriteSheet = null;
      InputStream inputStream = new ImageLoader("sprites/fonts/boxy.png").getFileStream();

      try {
        spriteSheet = new SpriteSheet(ImageIO.read(inputStream), 18, 16);
      } catch (IOException e) {
        e.printStackTrace();
      }

      SpriteSheetPackage sheetPackage = new DefaultFontSheetPackage();

//      context.registerService(Context.STRING_DRAWER, StringDrawer.class, new SpriteFont(spriteSheet, new BoxySpriteFontMap(), 0.5D));
      context.registerService(Context.STRING_DRAWER, StringDrawer.class, new SpriteFont(sheetPackage.getSpriteSheet("map1"), new DefaultFontMap(), 0.5D));

      context.setGuiWindow(gui);
      context.setInputKey(inputKey);
      context.setAppManager(new Manager(context));

      context.registerService(Context.AWT_GRAPHICS, AWTGraphicsCanvas.class, (Graphics2D)gui.getG2D());

      context.setLoop(this);

      this.context = context;

      gui.setTitlePrefix(configuration.getAppFullName());

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
    Manager   manager = (Manager) getSceneManager();

    window.setTitle(getExecutionInfo());
    manager.update(elapsed);

    // custom code below
    //
  }

  @Override
  protected void render() {
    GUIWindow window  = getGuiWindow();
    Manager   manager = (Manager) getSceneManager();

    window.clearFrame();
    manager.render(getCanvas());
    window.swapBuffer();
  }

  @Override
  public Context getContext() {
    return context;
  }

}
