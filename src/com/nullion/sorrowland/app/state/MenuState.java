package com.nullion.sorrowland.app.state;

import com.nullion.appcore.controller.Controller;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.state.AbstractState;
import com.nullion.appcore.state.ProcessMode;
import com.nullion.sorrowland.app.controller.MenuController;

public class MenuState extends AbstractState<Controller> {

  final static public String MENU_PROCESS = "MENU_PROCESS";

  public MenuState(AppContext context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    setProcessMode(ProcessMode.ACTIVE);
    registerController(MENU_PROCESS, MenuController.class, getContext(), this);
    setActiveController(MENU_PROCESS);
  }

}
