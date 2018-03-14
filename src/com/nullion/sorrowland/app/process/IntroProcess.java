package com.nullion.sorrowland.app.process;

import com.nullion.sorrowland.app.renderer.intro.Animation1Renderer;
import com.nullion.sorrowland.app.renderer.intro.Animation2Renderer;
import com.nullion.sorrowland.app.state.IntroState;
import com.nullion.appcore.renderer.AbstractRenderer;
import com.nullion.sorrowland.app.manager.AppManager;
import com.nullion.appcore.process.AbstractProcess;
import com.nullion.appcore.service.AppContext;

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
