package com.nullion.sorrowland.app.process;

import com.nullion.sorrowland.app.manager.AppManager;
import com.nullion.sorrowland.app.renderer.menu.MenuRenderer;
import com.nullion.sorrowland.app.state.MenuState;
import com.nullion.appcore.renderer.AbstractRenderer;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.process.AbstractProcess;

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
