package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.openworld.stats.Stats;

abstract public class Breed {

  public static final String HEALTH_KEY = "health";

  private String name;
  private Breed  parent;
  private Stats  stats;

  public Breed(double health, String name) {
    this.stats = new Stats();
    this.stats.setValue(HEALTH_KEY, health);
    this.name = name;
  }

  public Breed(Breed parent, double health, String name) {
    this(health, name);
    setParentBreed(parent);
  }

  public Stats getStats() {
    return stats;
  }

  public Breed getParent() {
    return parent;
  }

  public void setParentBreed(Breed breed) {
    this.stats.foldWith(breed.getStats());
  }

  public double getHealth() {
    return getStats().getValue(HEALTH_KEY);
  }

}
