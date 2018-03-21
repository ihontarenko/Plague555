package org.nulllab.ui.service;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.ui.process.SceneManager;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.loop.Loop;

public interface ContextAware {

  public Context getContext();

  default public SceneManager getControllerManager() {
    return getContext().getControllerManager();
  }

  default public Input getInputKey() {
    return getContext().getInputKey();
  }

  default public StringDrawer getStringDrawer() {
    return getContext().getStringDrawer();
  }

  default public GUIWindow getGuiWindow() {
    return getContext().getGuiWindow();
  }

  default public Canvas getCanvas() {
    return getContext().getCanvas();
  }

  default public Loop getLoop() {
    return getContext().getLoop();
  }

}
