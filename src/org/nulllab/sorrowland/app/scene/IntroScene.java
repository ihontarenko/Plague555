package org.nulllab.sorrowland.app.scene;

import org.nulllab.sorrowland.app.view.intro.LogoView;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.ui.process.scene.Scene;
import org.nulllab.ui.service.Context;

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
      getSceneManager().setActiveScene(Manager.STATE_MENU);
    }
  }

}
