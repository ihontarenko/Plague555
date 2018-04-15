package org.nulllab.nullengine.openworld.world.entities.monsters;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;
import org.nulllab.nullengine.openworld.object.component.physics.Physics;
import org.nulllab.nullengine.openworld.world.graphics.CharacterSpritesDefaultMapper;

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
