package org.nullapp.sorrowland.app.state;

import org.nullapp.sorrowland.core.process.AbstractProcess;
import org.nullapp.sorrowland.core.state.AbstractState;
import org.nullapp.sorrowland.core.state.ProcessMode;
import org.nullapp.sorrowland.app.manager.AppManager;
import org.nullapp.sorrowland.app.process.menu.MenuProcess;

public class MenuState extends AbstractState<AppManager, AbstractProcess> {

  final static public String MENU_PROCESS = "MENU_PROCESS";

  public MenuState(AppManager appManager) {
    super(appManager);
  }

  @Override
  protected void doInitialize() {
    setProcessMode(ProcessMode.ACTIVE);
    registerProcess(MENU_PROCESS, MenuProcess.class, getAppManager(), this);
    setActiveProcess(MENU_PROCESS);
  }

}
