package org.nullapp.sorrowland.app.state;

import org.nullapp.sorrowland.app.process.intro.IntroProcess;
import org.nullapp.sorrowland.core.process.AbstractProcess;
import org.nullapp.sorrowland.core.state.AbstractState;
import org.nullapp.sorrowland.core.state.ProcessMode;
import org.nullapp.sorrowland.app.manager.AppManager;

public class IntroState extends AbstractState<AppManager, AbstractProcess> {

  final static public String INTRO_ANIMATION = "INTRO_ANIMATION";

  public IntroState(AppManager sm) {
    super(sm);
  }

  @Override
  protected void doInitialize() {
    setProcessMode(ProcessMode.ACTIVE);
    setIntroActiveProcess();
  }

  public void setIntroActiveProcess()
  {
    registerProcess(INTRO_ANIMATION, new IntroProcess(getAppManager(), this));
    setActiveProcess(INTRO_ANIMATION);
  }

}
