package org.nulllab.nullengine.core.common;

import java.util.Random;

public class Probability {

  private static final int ONE_HUNDRED_PERCENT = 100;

  private double probability;
  private Random random;

  public Probability(int actual, int limit) {
    this((double) actual / (double) limit);
  }

  public Probability(double probability) {
    this.random = new Random();
    this.probability = probability;
  }

  public Probability(double actual, double limit) {
    this(actual / limit);
  }

  public double getProbability() {
    return probability;
  }

  public void setProbability(double probability) {
    this.probability = probability;
  }

  public boolean generate() {
    return (random.nextDouble() * ONE_HUNDRED_PERCENT) <= probability;
  }

}
