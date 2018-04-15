package org.nulllab.nullengine.openworld.world.entities.monsters;

import org.nulllab.nullengine.core.input.Input;

public class Chicken extends Monster {

  public Chicken(Input input) {
    super(input);
  }

  @Override
  String getPackageID() {
    return "mp1.monster6";
  }


}
