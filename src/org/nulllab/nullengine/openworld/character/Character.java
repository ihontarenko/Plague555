package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.equipment.Equipment;
import org.nulllab.nullengine.openworld.stats.Stats;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

  private Breed                           breed;
  private Observable<? extends Character> observable;
  private Stats stats;
  private Set<Equipment> equipment;

  public Character(Breed breed) {
    this.breed = breed;
    this.observable = new CharacterObservable();
  }

  public Breed getBreed() {
    return breed;
  }

  public Observable<? extends Character> getObservable() {
    return observable;
  }

  public Stats getStats() {
    return stats;
  }

  public Set<Equipment> getEquipment() {
    return equipment;
  }

}
