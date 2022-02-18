package org.borisovich.core.core.input;

public class NullInput implements Input {

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

}
