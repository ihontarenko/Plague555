package org.borisovich.core.openworld.world.entities.monsters;

import org.borisovich.core.core.input.Input;
import org.borisovich.core.openworld.character.Character;
import org.borisovich.core.openworld.object.component.graphics.Graphics;
import org.borisovich.core.openworld.object.component.physics.Physics;
import org.borisovich.core.openworld.world.graphics.CharacterSpritesDefaultMapper;

abstract public class Monster extends Character {

  public Monster(Input input) {
    super(input);

    Graphics graphics = getGraphics();
    Physics  physics  = getPhysics();

    // rewrite object height
    setHeight(32);
    // setup monster-character sprites pack
    graphics.setObjectSprites(new Monster.Sprites());
    // update inner bounds for correct collision
    physics.setInnerOffsetY(16D);
  }

  abstract String getPackageID();

  public class Sprites extends CharacterSpritesDefaultMapper {

    public Sprites() {
      super(Monster.this.getPackageID());
    }

    @Override
    public String getPackageName() {
      return null;
    }
  }

}
