package org.nullapp.sorrowland.app.manager;

import org.nullapp.sorrowland.core.state.AbstractState;
import org.nullapp.sorrowland.core.state.AbstractManager;
import org.nullapp.sorrowland.app.service.AppContext;
import org.nullapp.sorrowland.app.state.IntroState;
import org.nullapp.sorrowland.app.state.MenuState;

public class AppManager extends AbstractManager<AbstractState> {

  final static public String STATE_INTRO     = "STATE_INTRO";
  final static public String STATE_MENU = "STATE_MENU";
  final static public String STATE_GAME_PLAY = "STATE_GAME_PLAY";

  public AppManager(AppContext context) {
    super(context);
  }

  @Override
  public void doInitialize() {
    registerState(STATE_INTRO, new IntroState(this));
    registerState(STATE_MENU, new MenuState(this));

    setActiveState(STATE_INTRO);
  }

}