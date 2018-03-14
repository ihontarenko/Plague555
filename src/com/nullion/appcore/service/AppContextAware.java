package com.nullion.appcore.service;

import com.nullion.appcore.gui.GUIWindow;
import com.nullion.appcore.state.AbstractManager;
import com.nullion.appcore.gfx.StringDrawer;
import com.nullion.appcore.io.InputKey;
import com.nullion.appcore.loop.Loop;

public interface AppContextAware {

  public AppContext getContext();

  default public AbstractManager getAppManager() {
    return getContext().getAppManager();
  }

  default public InputKey getInputKey() {
    return getContext().getInputKey();
  }

  default public StringDrawer getStringDrawer() {
    return getContext().getStringDrawer();
  }

  default public GUIWindow getGuiWindow() {
    return getContext().getGuiWindow();
  }

  default public Loop getLoop() {
    return getContext().getLoop();
  }

}
