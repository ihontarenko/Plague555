package org.borisovich.core.openworld.character.ability;

abstract public class Ability {

  private String name;
  private double resourceCost;

  public Ability(String name, double resourceCost) {
    this.name = name;
    this.resourceCost = resourceCost;
  }

  public String getName() {
    return name;
  }

  public double getResourceCost() {
    return resourceCost;
  }

  abstract public void apply(Character character);

}
