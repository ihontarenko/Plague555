package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

  private Breed                  breed;
  private Observable<Character>  observable;
  private Values                 values;
  private Set<Equipment>         equipment;
  private CharacterSpritePackage spritePackage;

  public Character(Breed breed) {
    this.breed = breed;
    this.observable = new Observable<>();
    this.values = breed.getValues();
  }

  public double getHealth() {
    return getBreed().getHealth();
  }

  public Breed getBreed() {
    return breed;
  }

  public Observable getObservable() {
    return observable;
  }

  public Values getValues() {
    return values;
  }

  public Set<Equipment> getEquipment() {
    return equipment;
  }

}
