package org.borisovich.core.openworld.object.event;

import org.borisovich.core.core.event.Event;

public class OnCollideEvent extends Event {

  public static final String NAME = "onObjectCollideEvent";

  public OnCollideEvent() {
    super(NAME);
  }

}
