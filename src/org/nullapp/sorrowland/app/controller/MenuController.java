package org.nullapp.sorrowland.app.controller;

import org.nullapp.sorrowland.app.manager.Manager;
import org.nullapp.sorrowland.app.view.menu.MenuView;
import org.nullapp.appCore.process.view.AbstractView;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.appCore.process.controller.Controller;

import java.awt.event.KeyEvent;

public class MenuController extends Controller<AbstractView> {

  final static public String MENU = "MENU";

  public MenuController(AppContext context) {
    super(context);
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xff962222);

    if (getInputKey().getKey(KeyEvent.VK_ESCAPE)) {
      getAppManager().setActiveController(Manager.STATE_INTRO);
    }
  }

  @Override
  protected void doInitialize() {
    registerView(MENU, MenuView.class, getContext(), this);
    setActiveView(MENU);
  }

}
