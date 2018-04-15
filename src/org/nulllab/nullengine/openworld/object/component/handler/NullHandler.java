package org.nulllab.nullengine.openworld.object.component.handler;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.input.NullInput;
import org.nulllab.nullengine.openworld.object.GameObject;

public class NullHandler extends StateHandler {

  public NullHandler(GameObject object) {
    super(object, new NullInput());
  }

}
