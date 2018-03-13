package org.ionull.sorrowland.app.state;

import org.ionull.sorrowland.core.process.AbstractProcess;
import org.ionull.sorrowland.core.service.AppContext;
import org.ionull.sorrowland.core.state.AbstractState;
import org.ionull.sorrowland.core.state.ProcessMode;
import org.ionull.sorrowland.app.process.MenuProcess;

public class MenuState extends AbstractState<AbstractProcess> {

  final static public String MENU_PROCESS = "MENU_PROCESS";

  public MenuState(AppContext context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    setProcessMode(ProcessMode.ACTIVE);
    registerProcess(MENU_PROCESS, MenuProcess.class, getContext(), this);
    setActiveProcess(MENU_PROCESS);
  }

  @Override
  public void reinitialize() {
    getProcesses().values().forEach(AbstractProcess::reinitialize);
  }
}
