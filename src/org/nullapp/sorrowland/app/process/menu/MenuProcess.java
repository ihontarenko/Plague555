package org.nullapp.sorrowland.app.process.menu;

import org.nullapp.sorrowland.core.process.AbstractProcess;
import org.nullapp.sorrowland.core.renderer.AbstractRenderer;
import org.nullapp.sorrowland.app.manager.AppManager;
import org.nullapp.sorrowland.app.renderer.menu.MenuRenderer;
import org.nullapp.sorrowland.app.state.MenuState;

public class MenuProcess extends AbstractProcess<AppManager, MenuState, AbstractRenderer> {

  final static public String MENU = "MENU";

  public MenuProcess(AppManager appManager, MenuState state) {
    super(appManager, state);
  }

  @Override
  public void doUpdate(float nano) {
    getAppManager().getAppContext().getGuiWindow().getCanvas().setDefaultColor(0xff333333);
  }

  @Override
  protected void doInitialize() {
    registerRenderer(MENU, new MenuRenderer(getAppManager(), getState(), this));
  }

}
