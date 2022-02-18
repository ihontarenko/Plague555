package org.borisovich.core.openworld.configuration.entities;

import java.util.Objects;

abstract public class ConfigEntity<ParentConfig extends ConfigEntity> {

  private String parent;

  abstract public void overrideWith(ParentConfig parent);

  public boolean hasParent() {
    return !Objects.isNull(parent);
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  @Override
  public String toString() {
    return String.format("ConfigEntity{parent='%s'}", parent);
  }

}
