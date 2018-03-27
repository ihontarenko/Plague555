package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;
import org.nulllab.nullengine.openworld.character.level.Level;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

  private Breed                 breed;
  private Level                 level;
  private Skills                skills;
  private Observable<Character> observable;
  private Set<Equipment>        equipment;
  private Sprites               spritePackage;

  public Character(Breed breed) {
    this.breed = breed;
    this.observable = new Observable<>();
  }

  public double getHealth() {
    return getBreed().getHealth();
  }

  public Breed getBreed() {
    return breed;
  }

  public void setBreed(Breed breed) {
    this.breed = breed;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Skills getSkills() {
    return skills;
  }

  public void setSkills(Skills skills) {
    this.skills = skills;
  }

  public double getMana() {
    return getBreed().getMana();
  }

  public Sprites getSpritePackage() {
    return spritePackage;
  }

  public Observable getObservable() {
    return observable;
  }

  public Set<Equipment> getEquipment() {
    return equipment;
  }

  @Override
  public String toString() {
    return String.format("Character (%s) {%s, super: %s}",
        getClass().getSimpleName(), getBreed(), super.toString());
  }

}
