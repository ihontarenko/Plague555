package com.nullion.sorrowland.app.state;

import com.nullion.sorrowland.app.controller.IntroController;
import com.nullion.appcore.controller.Controller;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.state.AbstractState;

public class IntroState extends AbstractState<Controller> {

  final static public String INTRO_ANIMATION = "INTRO_ANIMATION";

  public IntroState(AppContext context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    registerController(INTRO_ANIMATION, IntroController.class, getContext(), this);
    setActiveController(INTRO_ANIMATION);
  }

}
