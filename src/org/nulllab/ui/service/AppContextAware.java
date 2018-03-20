package org.nulllab.ui.service;

import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.ui.process.ControllerManager;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.core.loop.Loop;

public interface AppContextAware {

  public AppContext getContext();

  default public ControllerManager getAppManager() {
    return getContext().getAppManager();
  }

  default public Keyboard getInputKey() {
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
