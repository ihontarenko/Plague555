package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.object.ActiveObject;
import org.nulllab.nullengine.openworld.character.equipment.Equipment;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.character.state.StandState;
import org.nulllab.nullengine.openworld.state.ObjectState;

import java.util.Set;

@SuppressWarnings("unused")
public class Character extends ActiveObject {

  protected ObjectState           state;
  protected Input                 input;
  private   Observable<Character> observable;
  private   Breed                 breed;
  private   Level                 level;
  private   Set<Equipment>        equipment;

  public Character(Breed breed, Input input) {
    super(0, 0, 1 << 4, 1 << 4);

    this.state = new StandState();
    this.observable = new Observable<>();
    this.input = input;
    this.breed = breed;

    this.setLayer(1 << 2);
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

  public Input getInput() {
    return input;
  }

  public void setInput(Input input) {
    this.input = input;
  }

  public void setObservable(Observable<Character> observable) {
    this.observable = observable;
  }

  public ObjectState getState() {
    return state;
  }

  public void setState(ObjectState state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return String.format("Character (%s) {%s, super: %s}",
        getClass().getSimpleName(), getBreed(), super.toString());
  }

  @Override
  @SuppressWarnings("unchecked")
  public void update(float nano) {
    ObjectState state = this.state.handle(this, input);

    if (state != null) {
      this.state.exitAction(this);
      setState(state);
      this.state.entryAction(this);
    }

    this.state.update(this);

    // todo
    getServiceLocator().getWorld().getCamera().syncPositionWith(getCentreX(), getCentreY());
  }


  @Override
  public void collide() {

  }
}
