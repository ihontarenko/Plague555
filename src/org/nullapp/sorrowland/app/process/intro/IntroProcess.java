package org.nullapp.sorrowland.app.process.intro;

import org.nullapp.sorrowland.core.common.Time;
import org.nullapp.sorrowland.core.process.AbstractProcess;
import org.nullapp.sorrowland.core.renderer.AbstractRenderer;
import org.nullapp.sorrowland.app.manager.AppManager;
import org.nullapp.sorrowland.app.renderer.intro.Animation1Renderer;
import org.nullapp.sorrowland.app.renderer.intro.Animation2Renderer;
import org.nullapp.sorrowland.app.state.IntroState;

public class IntroProcess extends AbstractProcess<AppManager, IntroState, AbstractRenderer> {

  final static public String ANIMATION1 = "ANIMATION1";
  final static public String ANIMATION2 = "ANIMATION2";

  private float elapsedTime;
  private float delay;

  public IntroProcess(AppManager sm, IntroState state) {
    super(sm, state);
  }

  @Override
  protected void doInitialize() {
    delay = Time.ONE_NANO_SECOND * 2;

    registerRenderer(ANIMATION2, new Animation2Renderer(getAppManager(), getState(), this));
    registerRenderer(ANIMATION1, new Animation1Renderer(getAppManager(), getState(), this));

  }

  @Override
  public void doUpdate(float nano) {
    elapsedTime += nano;

    if (elapsedTime > delay) {
      getAppManager().setActiveState(AppManager.STATE_MENU);
    }

  }

}
