package org.nulllab.nullengine.openworld.world.monster;

import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.world.monster.breed.OrcBreed;

public class Orc extends Character {

  public Orc() {
    super(new OrcBreed());
  }

}
