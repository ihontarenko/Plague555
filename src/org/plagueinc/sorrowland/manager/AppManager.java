package org.plagueinc.sorrowland.manager;

import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.AbstractManager;
import org.plagueinc.sorrowland.state.IntroState;
import org.plagueinc.sorrowland.state.MenuState;

public class AppManager extends AbstractManager<AbstractState> {

  final static public String STATE_INTRO     = "STATE_INTRO";
  final static public String STATE_MENU = "STATE_MENU";
  final static public String STATE_GAME_PLAY = "STATE_GAME_PLAY";

  @Override
  public void doInitialize() {

    registerState(STATE_INTRO, new IntroState(this));
    registerState(STATE_MENU, new MenuState(this));

    setActiveState(STATE_INTRO);
  }

}
