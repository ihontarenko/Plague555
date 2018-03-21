package org.nulllab.sorrowland.app.manager;

import org.nulllab.ui.process.scene.Scene;
import org.nulllab.ui.service.Context;
import org.nulllab.ui.process.SceneManager;
import org.nulllab.sorrowland.app.scene.IntroScene;
import org.nulllab.sorrowland.app.scene.MenuScene;

public class Manager extends SceneManager<Scene> {

  final static public String STATE_INTRO     = "STATE_INTRO";
  final static public String STATE_MENU      = "STATE_MENU";
  final static public String STATE_GAME_PLAY = "STATE_GAME_PLAY";

  public Manager(Context context) {
    super(context);
  }

  @Override
  public void doInitialize() {
    registerController(STATE_INTRO, IntroScene.class, getContext());
    registerController(STATE_MENU, MenuScene.class, getContext());
    setActiveScene(STATE_MENU);
  }
}