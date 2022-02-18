package org.borisovich.core.openworld.object.event;

import org.borisovich.core.core.event.Event;

public class OnMoveEvent extends Event {

  public static final String NAME = "onObjectMoveEvent";

  public OnMoveEvent() {
    super(NAME);
  }

}
