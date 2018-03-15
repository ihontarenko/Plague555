package org.nullapp.appCore.service;

import org.nullapp.appCore.gui.GUIWindow;
import org.nullapp.appCore.process.ControllerManager;
import org.nullapp.gameCore.gfx.StringDrawer;
import org.nullapp.appCore.io.InputKey;
import org.nullapp.appCore.loop.Loop;

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
