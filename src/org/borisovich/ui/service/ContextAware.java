package org.borisovich.ui.service;

import org.borisovich.core.core.graphics.Canvas;
import org.borisovich.core.core.input.Input;
import org.borisovich.ui.gui.GUIWindow;
import org.borisovich.ui.process.SceneManager;
import org.borisovich.core.core.graphics.StringDrawer;
import org.borisovich.core.core.loop.Loop;

public interface ContextAware {

  public Context getContext();

  default public SceneManager getSceneManager() {
    return getContext().getSceneManager();
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
