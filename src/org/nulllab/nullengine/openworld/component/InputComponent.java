package org.nulllab.nullengine.openworld.component;

import org.nulllab.nullengine.core.input.Input;

public class InputComponent implements Component, Input {

  private Input input;

  public InputComponent(Input input) {
    this.input = input;
  }

  @Override
  public boolean isPressed(int keyCode) {
    return input.isPressed(keyCode);
  }

  @Override
  public boolean isPressed(int keyCode, boolean withTimer) {
    return input.isPressed(keyCode, withTimer);
  }

  @Override
  public boolean isReleased(int keyCode) {
    return input.isReleased(keyCode);
  }

  @Override
  public boolean isReleased(int keyCode, boolean withTimer) {
    return input.isReleased(keyCode, withTimer);
  }

}
