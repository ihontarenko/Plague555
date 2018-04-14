package org.nulllab.nullengine.openworld.object.event;

import org.nulllab.nullengine.core.event.Event;

public class OnCollideEvent extends Event {

  public static final String NAME = "onObjectCollideEvent";

  public OnCollideEvent() {
    super(NAME);
  }

}
