package org.nulllab.sorrowland.app.scene;

import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.sorrowland.app.scene.view.WorldTestView;
import org.nulllab.ui.process.scene.Scene;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;

import java.awt.event.KeyEvent;

public class WorldTestScene extends Scene<AbstractView> {

  public WorldTestScene(Context context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    registerView("default", WorldTestView.class, getContext(), this);
    setActiveView("default");
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xffcccccc);

    if (getInputKey().isPressed(KeyEvent.VK_ESCAPE)) {
      getSceneManager().setActiveScene(Manager.STATE_INTRO);
    }
  }

}
