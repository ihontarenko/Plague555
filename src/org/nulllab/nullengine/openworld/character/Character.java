package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.input.CharacterHandler;
import org.nulllab.nullengine.openworld.object.component.physics.CharacterPhysics;
import org.nulllab.nullengine.openworld.world.Camera;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends GameObject {

//  private ObjectState           state;
  private Input                 input;
  private Observable<Character> observable;
  private Breed                 breed;
  private Level                 level;
  private Set<Equipment>        equipment;
  private Camera                camera;

  public Character(Breed breed, Input input) {
    super(0, 0, 32, 48);

//    this.state = new StandState();
    this.observable = new Observable<>();
    this.breed = breed;

    this.setPriority(1 << 2);
    this.setMovable(true);

    // overwrite state handler for character
    this.setStateHandler(new CharacterHandler(this, input));
    // overwrite physics for character
    this.setPhysics(new CharacterPhysics(this));

    getPhysics().setVelocity(2.0D);
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

  public Observable<Character> getObservable() {
    return observable;
  }

  public Set<Equipment> getEquipment() {
    return equipment;
  }

  public void setObservable(Observable<Character> observable) {
    this.observable = observable;
  }

  public Camera getCamera() {
    return camera;
  }

  public void setCamera(Camera camera) {
    this.camera = camera;
  }

  @Override
  public String toString() {
    return String.format("Character (%s) {%s, super: %s}",
        getClass().getSimpleName(), getBreed(), super.toString());
  }

  @Override
  @SuppressWarnings("unchecked")
  public void update(float nano) {
    getStateHandler().update(nano);
  }

}
