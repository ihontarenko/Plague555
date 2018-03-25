package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.openworld.stats.Stats;

public class Breed {

  public static final String HEALTH_KEY = "health";

  private Breed parent;
  private Stats stats;

  public Breed(double health) {
    this.stats = new Stats();
    this.stats.setValue(HEALTH_KEY, health);
  }

  public Breed(Breed parent) {
    this.parent = parent;
    this.stats.foldWith(parent.getStats());
  }

  public Stats getStats() {
    return stats;
  }

  public Breed getParent() {
    return parent;
  }

  public double getHealth() {
    return getStats().getValue(HEALTH_KEY);
  }

}
