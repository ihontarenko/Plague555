package org.borisovich.core.openworld.character.level;

import org.borisovich.core.core.common.Initializable;

import java.util.HashMap;
import java.util.Map;

public class Level {

  public static final int CHARACTER_MAX_LEVEL = 50;
  public static Calculator calculator;
  public        int        level;

  static {
    calculator = new Calculator();
  }

  public Level(int level) {
    this.level = level;
  }

  public double getScale() {
    return ((double)this.level / (CHARACTER_MAX_LEVEL / 10)) * getLevelFactor();
  }

  public double getLevelFactor() {
    return getCalculator().getLevelFactor(level);
  }

  public int getLevel() {
    return level;
  }

  public Calculator getCalculator() {
    return calculator;
  }

  public static class Calculator implements Initializable {

    private Map<Integer, Long>   total;
    private Map<Integer, Long>   experience;
    private Map<Integer, Double> scales;

    public Calculator() {
      this.experience = new HashMap<>();
      this.total = new HashMap<>();
      this.scales = new HashMap<>();
      initialize();
    }

    @Override
    public boolean isInitialized() {
      return experience.size() > 0;
    }

    @Override
    public void initialize() {
      if (!isInitialized()) {
        double maxLevel        = Level.CHARACTER_MAX_LEVEL * 2;
        double factor          = 1.5D;
        double reducer         = (factor - 1.2D) / maxLevel;
        long   experienceValue = 0L;
        long   totalExperience = experienceValue;

        this.experience.put(0, experienceValue);
        this.total.put(0, totalExperience);
        this.scales.put(0, factor);

        for (int level = 1; level <= maxLevel; level++) {
          experienceValue = (long) Math.pow(factor, level) + this.experience.get(level - 1);
          totalExperience += experienceValue;

          total.put(level, totalExperience);
          experience.put(level, experienceValue);
          scales.put(level, factor);

          factor = factor - reducer;
        }
      }
    }

    @Override
    public void reinitialize() {

    }

    public double getLevelFactor(int level) {
      return Math.pow(level, scales.get(level));
    }

    public long getNextExperience(int level) {
      return experience.get(level);
    }

    public long getExperience(int level) {
      return total.get(level);
    }

  }

}
