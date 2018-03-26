package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

  private Breed                  breed;
  private Observable<Character>  observable;
  private Set<Equipment>         equipment;
  private CharacterSpritePackage spritePackage;

  public Character(Breed breed) {
    this.breed = breed;
    this.observable = new Observable<>();
  }

  public double getHealth() {
    return getBreed().getHealth();
  }

  public double getMana() {
    return getBreed().getMana();
  }

  public void setBreed(Breed breed) {
    this.breed = breed;
  }

  public Breed getBreed() {
    return breed;
  }

  public Observable getObservable() {
    return observable;
  }

  public Set<Equipment> getEquipment() {
    return equipment;
  }

}
