package org.plagueinc.sorrowland.state;

import org.plagueinc.sorrowland.core.process.AbstractProcess;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.ProcessMode;
import org.plagueinc.sorrowland.manager.AppManager;
import org.plagueinc.sorrowland.process.menu.MenuProcess;

public class MenuState extends AbstractState<AppManager, AbstractProcess> {

  final static public String MENU_PROCESS = "MENU_PROCESS";

  public MenuState(AppManager appManager) {
    super(appManager);
  }

  @Override
  protected void doInitialize() {
    setProcessMode(ProcessMode.ACTIVE);
    setMenuActiveProcess();
  }

  public void setMenuActiveProcess()
  {
    MenuProcess process = new MenuProcess(getAppManager(), this);
    registerProcess(MENU_PROCESS, process);
    setActiveProcess(process);
  }

}
