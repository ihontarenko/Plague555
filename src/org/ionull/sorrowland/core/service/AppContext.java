package org.ionull.sorrowland.core.service;

import org.ionull.sorrowland.core.io.InputKey;
import org.ionull.sorrowland.app.gfx.text.StringDrawer;
import org.ionull.sorrowland.core.gui.GUIWindow;
import org.ionull.sorrowland.app.manager.AppManager;
import org.ionull.sorrowland.core.loop.Loop;

public class AppContext implements AppContextAware {

  private AppManager   appManager;
  private InputKey     inputKey;
  private GUIWindow    guiWindow;
  private StringDrawer stringDrawer;
  private Loop         loop;

  public InputKey getInputKey() {
    return inputKey;
  }

  public void setInputKey(InputKey inputKey) {
    this.inputKey = inputKey;
  }

  public StringDrawer getStringDrawer() {
    return stringDrawer;
  }

  public void setStringDrawer(StringDrawer stringDrawer) {
    this.stringDrawer = stringDrawer;
  }

  public GUIWindow getGuiWindow() {
    return guiWindow;
  }

  public void setGuiWindow(GUIWindow guiWindow) {
    this.guiWindow = guiWindow;
  }

  public AppManager getAppManager() {
    return appManager;
  }

  public void setAppManager(AppManager appManager) {
    this.appManager = appManager;
  }

  public Loop getLoop() {
    return loop;
  }

  public void setLoop(Loop loop) {
    this.loop = loop;
  }

  @Override
  public AppContext getContext() {
    return this;
  }
}
