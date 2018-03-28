package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.GameObject;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.character.state.StandState;
import org.nulllab.nullengine.openworld.component.GraphicComponent;
import org.nulllab.nullengine.openworld.component.InputComponent;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

  private Breed                 breed;
  private Level                 level;
  private Observable<Character> observable;
  private Set<Equipment>        equipment;
  private Sprites               spritePackage;

  public Character(Breed breed, InputComponent input, GraphicComponent graphic) {
    super(new StandState(), input, graphic);

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

  public double getMana() {
    return getBreed().getMana();
  }

  public void setSpritePackage(Sprites spritePackage) {
    this.spritePackage = spritePackage;
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

  @Override
  public void render(Canvas canvas) {
    getSprite().draw(canvas, getX(), getY());
  }

}
