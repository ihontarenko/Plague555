package org.nulllab.appCore.service;

import org.nulllab.appCore.gui.GUIWindow;
import org.nulllab.appCore.process.ControllerManager;
import org.nulllab.gameCore.gfx.StringDrawer;
import org.nulllab.appCore.io.InputKey;
import org.nulllab.appCore.loop.Loop;

public interface AppContextAware {

  public AppContext getContext();

  default public ControllerManager getAppManager() {
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
