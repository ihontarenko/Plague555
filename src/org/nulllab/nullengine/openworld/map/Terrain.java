package org.nulllab.nullengine.openworld.map;

public class Terrain {

  private Type   type;
  private double movementCost;

  public Terrain(Type type, double movementCost) {
    this.type = type;
    this.movementCost = movementCost;
  }

  public Type getType() {
    return type;
  }

  public double getMovementCost() {
    return movementCost;
  }

  public enum Type {
    WATER,
    SAND,
    GRASS;
  }

}
