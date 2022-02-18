package org.borisovich.plague555.app.manager;

import org.borisovich.plague555.app.scene.IntroScene;
import org.borisovich.plague555.app.scene.MenuScene;
import org.borisovich.plague555.app.scene.WorldTestScene;
import org.borisovich.ui.process.SceneManager;
import org.borisovich.ui.process.scene.Scene;
import org.borisovich.ui.service.Context;

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
    registerController(STATE_GAME_PLAY, WorldTestScene.class, getContext());
    setActiveScene(STATE_INTRO);
  }
}