package org.plagueinc.sorrowland.process.menu;

import org.plagueinc.sorrowland.core.process.AbstractProcess;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.manager.AppManager;
import org.plagueinc.sorrowland.renderer.menu.MenuRenderer;
import org.plagueinc.sorrowland.state.MenuState;

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
