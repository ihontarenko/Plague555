package org.nullapp.sorrowland.app.service;

import org.nullapp.sorrowland.core.io.InputKey;
import org.nullapp.sorrowland.app.gfx.text.StringDrawer;
import org.nullapp.sorrowland.app.gui.GUIWindow;
import org.nullapp.sorrowland.app.manager.AppManager;

public class AppContext {

  private AppManager appManager;
  private InputKey inputKey;
  private GUIWindow guiWindow;
  private StringDrawer stringDrawer;

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

}