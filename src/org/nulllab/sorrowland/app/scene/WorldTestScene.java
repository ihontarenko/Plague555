package org.nulllab.sorrowland.app.scene;

import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.character.level.Level;
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

    for (int i = 1; i < 100; i++) {
      Level level = new Level(i);
      System.out.println("lvl: " + i + ", health: " + 100* level.getScale());
    }

    int health = 100;
    int lvl = 100;
    Level level = new Level(lvl);
    Level level1 = new Level(37);

    System.out.println(level.getScale());

    System.out.println(level.getScale());

    health = (int) (health * level.getScale());

//    new Character(new TrollBreed());
//    new Character(new ElfBreed());

    System.out.println();

    System.exit(1);

    // new TrollElf();
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xffcccccc);

    if (getInputKey().isPressed(KeyEvent.VK_ESCAPE)) {
      getSceneManager().setActiveScene(Manager.STATE_INTRO);
    }
  }

}
