package org.borisovich.core.openworld.world.entities.monsters;

import org.borisovich.core.core.input.Input;

public class Orc extends Monster {

  public Orc(Input input) {
    super(input);
  }

  @Override
  String getPackageID() {
    return "mp1.monster2";
  }

}
