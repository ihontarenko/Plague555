package org.ionull.sorrowland.app.state;

import org.ionull.sorrowland.app.process.IntroProcess;
import org.ionull.sorrowland.core.process.AbstractProcess;
import org.ionull.sorrowland.core.service.AppContext;
import org.ionull.sorrowland.core.state.AbstractState;

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
