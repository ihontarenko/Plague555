package org.nulllab.nullengine.openworld.world.entities.monsters;

import org.nulllab.nullengine.core.input.Input;

public class Troll extends Monster {

  public Troll(Input input) {
    super(input);
  }

  @Override
  String getPackageID() {
    return "mp1.monster5";
  }
}
