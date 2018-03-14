package com.nullion.appcore.service;

import com.nullion.sorrowland.app.gfx.text.StringDrawer;
import com.nullion.sorrowland.app.manager.AppManager;
import com.nullion.appcore.gui.GUIWindow;
import com.nullion.appcore.io.InputKey;
import com.nullion.appcore.loop.Loop;

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
