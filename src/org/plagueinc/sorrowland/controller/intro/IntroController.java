package org.plagueinc.sorrowland.controller.intro;

import org.plagueinc.sorrowland.core.controller.AbstractController;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.manager.GameStateManager;
import org.plagueinc.sorrowland.renderer.intro.Animation1Renderer;
import org.plagueinc.sorrowland.renderer.intro.Animation2Renderer;
import org.plagueinc.sorrowland.state.IntroState;

public class IntroController extends AbstractController<GameStateManager, IntroState, AbstractRenderer> {

  final static public String ANIMATION1 = "ANIMATION1";
  final static public String ANIMATION2 = "ANIMATION2";

  public IntroController(GameStateManager stateManager, IntroState state) {
    super(stateManager, state);
  }

  @Override
  protected void doInitialize() {
    registerRenderer(ANIMATION1, new Animation1Renderer(getStateManager(), getState(), this));
    registerRenderer(ANIMATION2, new Animation2Renderer(getStateManager(), getState(), this));
  }

  @Override
  public void update(float nanoSeconds) {

  }

}
