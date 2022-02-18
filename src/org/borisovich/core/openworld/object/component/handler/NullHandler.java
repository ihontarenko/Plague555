package org.borisovich.core.openworld.object.component.handler;

import org.borisovich.core.core.input.NullInput;
import org.borisovich.core.openworld.object.GameObject;

public class NullHandler extends StateHandler {

  public NullHandler(GameObject object) {
    super(object, new NullInput());
  }

}
