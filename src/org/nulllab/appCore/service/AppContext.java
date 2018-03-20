package org.nulllab.appCore.service;

import org.nulllab.appCore.common.Initializable;
import org.nulllab.appCore.config.AbstractConfiguration;
import org.nulllab.appCore.container.ServiceLocator;
import org.nulllab.appCore.gui.GUIWindow;
import org.nulllab.appCore.io.InputKey;
import org.nulllab.appCore.loop.Loop;
import org.nulllab.appCore.process.ControllerManager;
import org.nulllab.gameCore.gfx.StringDrawer;

public class AppContext extends ServiceLocator<Object> implements AppContextAware, Initializable {

  public final static String CONFIG_OBJECT = "CONFIG_OBJECT";
  public final static String INPUT_KEY     = "INPUT_KEY";
  public final static String STRING_DRAWER = "STRING_DRAWER";
  public final static String GUI_WINDOW    = "GUI_WINDOW";
  public final static String APP_MANAGER   = "APP_MANAGER";
  public final static String LOOP_OBJECT   = "LOOP_OBJECT";

  private boolean initialized = false;

  public AbstractConfiguration getConfiguration() {
    return (AbstractConfiguration) getObject(CONFIG_OBJECT);
  }

  public void setConfiguration(AbstractConfiguration configuration) {
    setObject(CONFIG_OBJECT, configuration);
  }

  public InputKey getInputKey() {
    return (InputKey) getObject(INPUT_KEY);
  }

  public void setInputKey(InputKey inputKey) {
    setObject(INPUT_KEY, inputKey);
  }

  public StringDrawer getStringDrawer() {
    return (StringDrawer) getObject(STRING_DRAWER);
  }

  public void setStringDrawer(StringDrawer stringDrawer) {
    setObject(STRING_DRAWER, stringDrawer);
  }

  public GUIWindow getGuiWindow() {
    return (GUIWindow) getObject(GUI_WINDOW);
  }

  public void setGuiWindow(GUIWindow guiWindow) {
    setObject(GUI_WINDOW, guiWindow);
  }

  public ControllerManager getAppManager() {
    return (ControllerManager) getObject(APP_MANAGER);
  }

  public void setAppManager(ControllerManager appManager) {
    setObject(APP_MANAGER, appManager);
  }

  public Loop getLoop() {
    return (Loop) getObject(LOOP_OBJECT);
  }

  public void setLoop(Loop loop) {
    setObject(LOOP_OBJECT, loop);
  }

  @Override
  public AppContext getContext() {
    return this;
  }

  @Override
  public boolean isInitialized() {
    return initialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      // do init...
      initialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

}
