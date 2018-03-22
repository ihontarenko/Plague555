package org.nulllab.sorrowland.app.scene;

import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.sorrowland.app.view.menu.MenuView;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;
import org.nulllab.ui.process.scene.Scene;

import java.awt.event.KeyEvent;

public class MenuScene extends Scene<AbstractView> {

  final static public String MENU = "MENU";

  public MenuScene(Context context) {
    super(context);
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xffcccccc);

    if (getInputKey().isPressed(KeyEvent.VK_ESCAPE)) {
      getSceneManager().setActiveScene(Manager.STATE_INTRO);
    }
  }

  @Override
  protected void doInitialize() {
    registerView(MENU, MenuView.class, getContext(), this);
    setActiveView(MENU);
  }

}
