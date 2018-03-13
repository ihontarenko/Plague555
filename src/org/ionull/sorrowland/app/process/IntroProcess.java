package org.ionull.sorrowland.app.process;

import org.ionull.sorrowland.app.manager.AppManager;
import org.ionull.sorrowland.core.process.AbstractProcess;
import org.ionull.sorrowland.core.renderer.AbstractRenderer;
import org.ionull.sorrowland.app.renderer.intro.Animation1Renderer;
import org.ionull.sorrowland.app.renderer.intro.Animation2Renderer;
import org.ionull.sorrowland.app.state.IntroState;
import org.ionull.sorrowland.core.service.AppContext;

import java.awt.event.KeyEvent;

public class IntroProcess extends AbstractProcess<IntroState, AbstractRenderer> {

  final static public String ANIMATION1 = "ANIMATION1";
  final static public String ANIMATION2 = "ANIMATION2";

  public IntroProcess(AppContext context, IntroState state) {
    super(context, state);
  }

  @Override
  protected void doInitialize() {
    registerRenderer(ANIMATION1, Animation1Renderer.class, getContext(), getState(), this);
    registerRenderer(ANIMATION2, Animation2Renderer.class, getContext(), getState(), this);
    getRenderers().resolveAll();
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xff229654);
    if (getInputKey().getKey(KeyEvent.VK_2)) {
      getAppManager().setActiveState(AppManager.STATE_MENU);
    }
  }

}
