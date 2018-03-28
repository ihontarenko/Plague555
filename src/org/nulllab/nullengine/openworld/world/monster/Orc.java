package org.nulllab.nullengine.openworld.world.monster;

import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.component.GraphicComponent;
import org.nulllab.nullengine.openworld.component.InputComponent;
import org.nulllab.nullengine.openworld.world.monster.breed.OrcBreed;

public class Orc extends Character {

  public Orc(InputComponent input, GraphicComponent graphic) {
    super(new OrcBreed(), input, graphic);
  }
}
