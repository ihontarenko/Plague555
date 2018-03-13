package org.plagueinc.sorrowland.state;

import org.plagueinc.sorrowland.process.intro.IntroProcess;
import org.plagueinc.sorrowland.core.process.AbstractProcess;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.ProcessMode;
import org.plagueinc.sorrowland.manager.AppManager;

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
