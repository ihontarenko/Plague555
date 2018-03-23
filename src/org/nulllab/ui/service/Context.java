package org.nulllab.ui.service;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.config.AbstractConfiguration;
import org.nulllab.nullengine.core.container.ObjectManager;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.loop.Loop;
import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.ui.process.SceneManager;

public class Context extends ObjectManager<Object> implements ContextAware, Initializable {

  public final static String CONFIG_OBJECT = "CONFIG_OBJECT";
  public final static String AWT_GRAPHICS  = "AWT_GRAPHICS";
  public final static String INPUT_KEY     = "INPUT_KEY";
  public final static String STRING_DRAWER = "STRING_DRAWER";
  public final static String GUI_WINDOW    = "GUI_WINDOW";
  public final static String SCENE_MANAGER = "SCENE_MANAGER";
  public final static String LOOP_OBJECT   = "LOOP_OBJECT";

  private boolean initialized = false;

  public AbstractConfiguration getConfiguration() {
    return (AbstractConfiguration) getObject(CONFIG_OBJECT);
  }

  public void setConfiguration(AbstractConfiguration configuration) {
    setObject(CONFIG_OBJECT, configuration);
  }

  public Input getInputKey() {
    return (Input) getObject(INPUT_KEY);
  }

  public void setInputKey(Input inputKey) {
    setObject(INPUT_KEY, inputKey);
  }

  public StringDrawer getStringDrawer() {
    return (StringDrawer) getObject(STRING_DRAWER);
  }

  public void setStringDrawer(StringDrawer stringDrawer) {
    setObject(STRING_DRAWER, stringDrawer);
  }

  public GUIWindow getGuiWindow() {
    return (GUIWindow) getObject(GUI_WINDOW);
  }

  public void setGuiWindow(GUIWindow guiWindow) {
    setObject(GUI_WINDOW, guiWindow);
  }

  public Canvas getCanvas() {
    return (Canvas) getObject(AWT_GRAPHICS);
  }

  public SceneManager getSceneManager() {
    return (SceneManager) getObject(SCENE_MANAGER);
  }

  public void setAppManager(SceneManager appManager) {
    setObject(SCENE_MANAGER, appManager);
  }

  public Loop getLoop() {
    return (Loop) getObject(LOOP_OBJECT);
  }

  public void setLoop(Loop loop) {
    setObject(LOOP_OBJECT, loop);
  }

  @Override
  public Context getContext() {
    return this;
  }

  @Override
  public boolean isInitialized() {
    return initialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      // do init...
      initialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

}
