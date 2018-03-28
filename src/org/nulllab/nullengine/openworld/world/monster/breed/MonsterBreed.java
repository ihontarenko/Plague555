package org.nulllab.nullengine.openworld.world.monster.breed;

import org.nulllab.nullengine.openworld.character.Breed;

public class MonsterBreed extends Breed {

  public MonsterBreed(String name) {
    super(name);

    setMana(100D);
    setHealth(120D);
  }

}
