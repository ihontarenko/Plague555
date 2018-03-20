package org.nulllab.sorrowland.app.manager;

import org.nulllab.ui.process.controller.Controller;
import org.nulllab.ui.service.AppContext;
import org.nulllab.ui.process.ControllerManager;
import org.nulllab.sorrowland.app.controller.IntroController;
import org.nulllab.sorrowland.app.controller.MenuController;

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
    setActiveController(STATE_MENU);
  }
}