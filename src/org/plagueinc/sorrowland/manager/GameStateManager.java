package org.plagueinc.sorrowland.manager;

import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.AbstractStateManager;
import org.plagueinc.sorrowland.state.IntroState;

public class GameStateManager extends AbstractStateManager<AbstractState> {

  final static public String INTRO = "INTRO";
  final static public String GAME_PLAY = "GAME_PLAY";

  @Override
  public void doInitialize() {
    registerState(INTRO, new IntroState(this));
    setActiveState(INTRO);
  }

}
