package org.nulllab.nullengine.core.event;

abstract public class Event {

  private String name;

  public Event(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
