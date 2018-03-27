package org.nulllab.sorrowland.app.scene;

import org.nulllab.nullengine.core.common.Probability;
import org.nulllab.nullengine.openworld.character.Breed;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.character.Skills;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.world.monster.Orc;
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
    Level level = new Level(1);
    Level level1 = new Level(37);

    Probability probability = new Probability(45);

    if (probability.generate()) {
      System.out.println(String.format("%d %% was probability what you see this", (int)probability.getProbability()));
    }

    Skills skills = new Skills();

    health = health + (int)(health / 10 * level.getScale());

    System.out.println(health);
    System.out.println(level.getCalculator().getExperience(13));

    Orc orc = new Orc();

    skills.getDefense();
    skills.getDexterity();
    skills.getIntellegence();


    Breed trollDarkElf = new Breed("Troll");
    trollDarkElf.setParentBreed(new Breed("Dark Elf"));
    trollDarkElf.getParent().setParentBreed(new Breed("Zombie Genom"));
    System.out.println(trollDarkElf.getFullName("/"));

    orc.getBreed().setParentBreed(new Breed("Dwarf"));

    System.out.println(orc);

    Character character = new Character(trollDarkElf);
//    new Character(new ElfBreed());

//    character.getSkills().getDefense();

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
