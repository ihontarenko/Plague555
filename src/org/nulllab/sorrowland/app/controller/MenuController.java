package org.nulllab.sorrowland.app.controller;

import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.sorrowland.app.view.menu.MenuView;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.AppContext;
import org.nulllab.ui.process.controller.Controller;

import java.awt.event.KeyEvent;

public class MenuController extends Controller<AbstractView> {

  final static public String MENU = "MENU";

  public MenuController(AppContext context) {
    super(context);
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xffcccccc);

    if (getInputKey().isPressed(KeyEvent.VK_ESCAPE)) {
      getAppManager().setActiveController(Manager.STATE_INTRO);
    }
  }

  @Override
  protected void doInitialize() {
    registerView(MENU, MenuView.class, getContext(), this);
    setActiveView(MENU);
  }

}
