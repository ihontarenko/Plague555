package org.nulllab.nullengine.openworld.object.component.input;

import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.openworld.object.GameObject;

public class NullHandler extends StateHandler {

  public NullHandler(GameObject object) {
    super(object);
  }

  @Override
  public Input getInput() {
    return new Input() {

      @Override
      public int getPressed() {
        return 0;
      }

      @Override
      public boolean isPressed(int keyCode) {
        return false;
      }

      @Override
      public boolean isPressed(int keyCode, boolean withTimer) {
        return false;
      }

      @Override
      public boolean isReleased(int keyCode) {
        return false;
      }

      @Override
      public boolean isReleased(int keyCode, boolean withTimer) {
        return false;
      }

    };
  }

}
