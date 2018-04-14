package org.nulllab.nullengine.openworld.object.event;

import org.nulllab.nullengine.core.event.Event;

public class OnMoveEvent extends Event {

  public static final String NAME = "onObjectMoveEvent";

  public OnMoveEvent() {
    super(NAME);
  }

}
