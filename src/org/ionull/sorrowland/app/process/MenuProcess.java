package org.ionull.sorrowland.app.process;

import org.ionull.sorrowland.core.process.AbstractProcess;
import org.ionull.sorrowland.core.renderer.AbstractRenderer;
import org.ionull.sorrowland.app.manager.AppManager;
import org.ionull.sorrowland.app.renderer.menu.MenuRenderer;
import org.ionull.sorrowland.app.state.MenuState;
import org.ionull.sorrowland.core.service.AppContext;

import java.awt.event.KeyEvent;

public class MenuProcess extends AbstractProcess<MenuState, AbstractRenderer> {

  final static public String MENU = "MENU";

  public MenuProcess(AppContext context, MenuState state) {
    super(context, state);
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xff962222);

    if (getInputKey().getKey(KeyEvent.VK_ESCAPE)) {
      getAppManager().setActiveState(AppManager.STATE_INTRO);
    }
  }

  @Override
  protected void doInitialize() {
    registerRenderer(MENU, MenuRenderer.class, getContext(), getState(), this);
    getRenderers().resolveAll();
  }

  @Override
  public void reinitialize() {
    System.out.printf("%s.reinitialize();%n", getClass().getSimpleName());
  }

}
