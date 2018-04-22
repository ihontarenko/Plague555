package org.nulllab.nullengine.openworld.configuration.entities;

import org.nulllab.nullengine.openworld.character.Skills;

public class PlayerConfig extends ConfigEntity<PlayerConfig> {

  private String name;
  private Skills skills;

  public PlayerConfig() {
    this.skills = new Skills();
  }

  public String getName() {
    return name;
  }

  public Skills getSkills() {
    return skills;
  }

  @Override
  public void overrideWith(PlayerConfig parent) {
    skills.mergeWith(parent.getSkills());
  }

  @Override
  public String toString() {
    return String.format("PlayerConfig{name='%s', skills=%s super=%s}", name, skills, super.toString());
  }

}
