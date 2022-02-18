package org.borisovich.core.openworld.world.entities.monsters;

import org.borisovich.core.core.input.Input;

public class Raven extends Monster {

  public Raven(Input input) {
    super(input);
  }

  @Override
  String getPackageID() {
    return "mp1.monster6";
  }


}
