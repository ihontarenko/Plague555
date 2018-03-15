package org.nullapp.sorrowland.app.manager;

import org.nullapp.appCore.process.controller.Controller;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.appCore.process.ControllerManager;
import org.nullapp.sorrowland.app.controller.IntroController;
import org.nullapp.sorrowland.app.controller.MenuController;

public class Manager extends ControllerManager<Controller> {

  final static public String STATE_INTRO     = "STATE_INTRO";
  final static public String STATE_MENU      = "STATE_MENU";
  final static public String STATE_GAME_PLAY = "STATE_GAME_PLAY";

  public Manager(AppContext context) {
    super(context);
  }

  @Override
  public void doInitialize() {
    registerController(STATE_INTRO, IntroController.class, getContext());
    registerController(STATE_MENU, MenuController.class, getContext());
    setActiveController(STATE_INTRO);
  }
}