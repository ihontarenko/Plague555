package org.ionull.sorrowland.core.service;

import org.ionull.sorrowland.app.gfx.text.StringDrawer;
import org.ionull.sorrowland.core.gui.GUIWindow;
import org.ionull.sorrowland.core.io.InputKey;
import org.ionull.sorrowland.core.loop.Loop;
import org.ionull.sorrowland.core.state.AbstractManager;

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
