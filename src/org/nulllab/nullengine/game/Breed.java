package org.nulllab.nullengine.game;

public class Breed {

  private Breed parent;

  private double health;

  public Breed() {
    this(null);
  }

  public Breed(Breed parent) {
    this.parent = parent;
  }

}
