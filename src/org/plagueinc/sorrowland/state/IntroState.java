package org.plagueinc.sorrowland.state;

import org.plagueinc.sorrowland.controller.intro.IntroController;
import org.plagueinc.sorrowland.core.controller.AbstractController;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.ProcessMode;
import org.plagueinc.sorrowland.manager.GameStateManager;

public class IntroState extends AbstractState<GameStateManager, AbstractController> {

  final static public String INTRO_ANIMATION = "INTRO_ANIMATION";

  public IntroState(GameStateManager stateManager) {
    super(stateManager);
  }

  @Override
  protected void doInitialize() {
    registerController(INTRO_ANIMATION, new IntroController(getStateManager(), this));
    setProcessMode(ProcessMode.ACTIVE);
    setActiveController(INTRO_ANIMATION);
  }

}
