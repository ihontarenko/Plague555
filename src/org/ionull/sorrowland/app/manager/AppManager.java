package org.ionull.sorrowland.app.manager;

import org.ionull.sorrowland.core.state.AbstractState;
import org.ionull.sorrowland.core.state.AbstractManager;
import org.ionull.sorrowland.core.service.AppContext;
import org.ionull.sorrowland.app.state.IntroState;
import org.ionull.sorrowland.app.state.MenuState;

public class AppManager extends AbstractManager<AbstractState> {

  final static public String STATE_INTRO     = "STATE_INTRO";
  final static public String STATE_MENU = "STATE_MENU";
  final static public String STATE_GAME_PLAY = "STATE_GAME_PLAY";

  public AppManager(AppContext context) {
    super(context);
  }

  @Override
  public void doInitialize() {
    registerState(STATE_INTRO, IntroState.class, getContext());
    registerState(STATE_MENU, MenuState.class, getContext());

    setActiveState(STATE_INTRO);
  }

}