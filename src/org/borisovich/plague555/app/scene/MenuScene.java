package org.borisovich.plague555.app.scene;

import org.borisovich.plague555.app.scene.view.MenuView;
import org.borisovich.plague555.app.manager.Manager;
import org.borisovich.ui.gui.GUIFrame;
import org.borisovich.ui.process.view.AbstractView;
import org.borisovich.ui.service.Context;
import org.borisovich.ui.process.scene.Scene;

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
