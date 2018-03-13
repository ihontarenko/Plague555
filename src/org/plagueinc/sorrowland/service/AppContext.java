package org.plagueinc.sorrowland.service;

import org.plagueinc.sorrowland.core.context.AbstractAppContext;
import org.plagueinc.sorrowland.core.io.InputKey;
import org.plagueinc.sorrowland.gui.GUIWindow;
import org.plagueinc.sorrowland.manager.AppManager;

public class AppContext extends AbstractAppContext {

  private AppManager appManager;
  private InputKey inputKey;
  private GUIWindow guiWindow;

  public InputKey getInputKey() {
    return inputKey;
  }

  public void setInputKey(InputKey inputKey) {
    this.inputKey = inputKey;
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
