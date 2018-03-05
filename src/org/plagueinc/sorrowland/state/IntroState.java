package org.plagueinc.sorrowland.state;

import org.plagueinc.sorrowland.controller.intro.IntroController;
import org.plagueinc.sorrowland.core.controller.AbstractController;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.manager.GameStateManager;

public class IntroState extends AbstractState<GameStateManager, AbstractController> {

  final static public String ANIMATION1 = "ANIMATION1";
  final static public String ANIMATION2 = "ANIMATION2";

  public IntroState(GameStateManager stateManager) {
    super(stateManager);
  }

  @Override
  protected void doInitialize() {
    registerController(ANIMATION1, new IntroController(getStateManager(), this));
    registerController(ANIMATION2, new IntroController(getStateManager(), this));
    setProcessMode(ProcessMode.ACTIVE);
    setActiveController(ANIMATION2);
  }

}
