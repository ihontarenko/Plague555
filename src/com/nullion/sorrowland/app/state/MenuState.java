package com.nullion.sorrowland.app.state;

import com.nullion.appcore.process.AbstractProcess;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.state.AbstractState;
import com.nullion.appcore.state.ProcessMode;
import com.nullion.sorrowland.app.process.MenuProcess;

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
