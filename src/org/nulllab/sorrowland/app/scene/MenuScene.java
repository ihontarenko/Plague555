package org.nulllab.sorrowland.app.scene;

import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.sorrowland.app.scene.view.MenuView;
import org.nulllab.ui.gui.GUIFrame;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;
import org.nulllab.ui.process.scene.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScene extends Scene<AbstractView> {

  final static public String MENU = "MENU";

  public MenuScene(Context context) {
    super(context);
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xffcccccc);

    if (getInputKey().isPressed(KeyEvent.VK_F1)) {
      getSceneManager().setActiveScene(Manager.STATE_INTRO);
    } else if (getInputKey().isPressed(KeyEvent.VK_F2)) {
      getSceneManager().setActiveScene(Manager.STATE_GAME_PLAY);
    }

  }

  @Override
  protected void doInitialize() {
    registerView(MENU, MenuView.class, getContext(), this);
    setActiveView(MENU);

    GUIFrame frame = getContext().getGuiWindow().getMainFrame();
    Dimension dimension = new Dimension(640, 480);

    frame.setSize(dimension);
    frame.getCanvas().setSize(dimension);
    frame.updateUI();
  }

}
