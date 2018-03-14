package com.nullion.sorrowland.app.controller;

import com.nullion.sorrowland.app.view.intro.LogoView;
import com.nullion.sorrowland.app.state.IntroState;
import com.nullion.appcore.view.AbstractView;
import com.nullion.sorrowland.app.manager.AppManager;
import com.nullion.appcore.controller.Controller;
import com.nullion.appcore.service.AppContext;

import java.awt.event.KeyEvent;

public class IntroController extends Controller<IntroState, AbstractView> {

  final static public String LOGO = "LOGO";

  public IntroController(AppContext context, IntroState state) {
    super(context, state);
  }

  @Override
  protected void doInitialize() {
    registerView(LOGO, LogoView.class, getContext(), getState(), this);
    setActiveView(LOGO);
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xff229654);
    if (getInputKey().getKey(KeyEvent.VK_2)) {
      getAppManager().setActiveState(AppManager.STATE_MENU);
    }
  }

}
