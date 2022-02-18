package org.borisovich.plague555.app.scene;

import org.borisovich.plague555.app.scene.view.LogoView;
import org.borisovich.ui.process.view.AbstractView;
import org.borisovich.plague555.app.manager.Manager;
import org.borisovich.ui.process.scene.Scene;
import org.borisovich.ui.service.Context;

import java.awt.event.KeyEvent;

public class IntroScene extends Scene<AbstractView> {

  final static public String LOGO = "LOGO";

  public IntroScene(Context context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    registerView(LOGO, LogoView.class, getContext(), this);
    setActiveView(LOGO);
  }

  @Override
  public void doUpdate(float nano) {
    if (getInputKey().isPressed(KeyEvent.VK_2)) {
      getSceneManager().setActiveScene(Manager.STATE_GAME_PLAY);
    }
  }

}
