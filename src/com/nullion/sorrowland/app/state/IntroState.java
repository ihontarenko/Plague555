package com.nullion.sorrowland.app.state;

import com.nullion.sorrowland.app.process.IntroProcess;
import com.nullion.appcore.process.AbstractProcess;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.state.AbstractState;

public class IntroState extends AbstractState<AbstractProcess> {

  final static public String INTRO_ANIMATION = "INTRO_ANIMATION";

  public IntroState(AppContext context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    registerProcess(INTRO_ANIMATION, IntroProcess.class, getContext(), this);
    setActiveProcess(INTRO_ANIMATION);
  }

}
