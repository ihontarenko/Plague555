package org.nulllab.nullengine.openworld.configuration.entities;

import java.util.HashMap;
import java.util.Map;

public class PlayerConfig {

  private String              name;
  private Map<String, Double> skills;

  public PlayerConfig() {
    name = "Test";
    skills = new HashMap<>();
    skills.put("velocity", 1.4D);
  }

  @Override
  public String toString() {
    return String.format("Name: %sSkills: %s", name, skills);
  }
}
