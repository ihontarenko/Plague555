package org.nulllab.nullengine.openworld.stats;

import java.util.HashMap;
import java.util.Map;

abstract public class Stats {

  private Map<String, StatsValue> statsValues;

  public Stats() {
    this.statsValues = new HashMap<>();
  }

  public StatsValue getStats(String keyName) {
    return statsValues.get(keyName);
  }

  public <V> V getStatsValue(String keyName) {
    return (V) statsValues.get(keyName).getValue();
  }

  public void addStats(String keyName, StatsValue statsValue) {
    statsValues.put(keyName, statsValue);
//    for (String keyName : stats.getStatsValues().keySet()) {
//
//    }
  }

  public Map<String, StatsValue> getStatsValues() {
    return statsValues;
  }

}
