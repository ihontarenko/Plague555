package org.nulllab.nullengine.openworld.object.character;

import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.openworld.object.GameObject;

public class Character extends GameObject {

  private Breed                           breed;
  private Observable<? extends Character> observable;

  public Character(Breed breed) {
    this.breed = breed;
    this.observable = new Observable<Character>() {
    };
  }


}
