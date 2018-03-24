package org.nulllab.nullengine.openworld.character;

import org.nulllab.nullengine.openworld.stats.Stats;

public class Breed {

  private Breed parent;
  private Stats stats;

  public Breed() {
    this(null);
  }

  public Breed(Breed parent) {
    this.parent = parent;
  }

  public Breed getParent() {
    return parent;
  }

  public Stats getStats() {
    return stats;
  }

}
