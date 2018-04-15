package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.handler.CharacterHandler;
import org.nulllab.nullengine.openworld.object.component.physics.CharacterPhysics;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

//  private ObjectState           state;
  private Input                 input;

  private Level                 level;
  private Set<Equipment>        equipment;

  public Character(Input input) {
    super(0, 0, 32, 48);

//    this.state = new StandState();


    this.setPriority(1 << 2);
    this.setMovable(true);

    // overwrite state handler for character
    this.setStateHandler(new CharacterHandler(this, input));
    // overwrite physics for character
    this.setPhysics(new CharacterPhysics(this));

    getPhysics().setVelocity(2.0D);
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Set<Equipment> getEquipment() {
    return equipment;
  }

  @Override
  public String toString() {
    return String.format("Character (%s) {super: %s}",
        getClass().getSimpleName(), super.toString());
  }

  @Override
  @SuppressWarnings("unchecked")
  public void update(float nano) {
    getStateHandler().update(nano);
  }

}
