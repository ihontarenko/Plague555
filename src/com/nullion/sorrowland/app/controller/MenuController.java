package com.nullion.sorrowland.app.controller;

import com.nullion.sorrowland.app.manager.AppManager;
import com.nullion.sorrowland.app.view.menu.MenuView;
import com.nullion.sorrowland.app.state.MenuState;
import com.nullion.appcore.view.AbstractView;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.controller.Controller;

import java.awt.event.KeyEvent;

public class MenuController extends Controller<MenuState, AbstractView> {

  final static public String MENU = "MENU";

  public MenuController(AppContext context, MenuState state) {
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
    registerView(MENU, MenuView.class, getContext(), getState(), this);
    setActiveView(MENU);
  }

}
