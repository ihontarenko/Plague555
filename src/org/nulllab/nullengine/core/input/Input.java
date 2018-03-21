package org.nulllab.nullengine.core.input;

import java.awt.event.KeyEvent;

public interface Input {

  int LEFT  = KeyEvent.VK_LEFT;
  int RIGHT = KeyEvent.VK_RIGHT;
  int UP    = KeyEvent.VK_UP;
  int DOWN  = KeyEvent.VK_DOWN;

  int BUTTON_0  = KeyEvent.VK_0;
  int BUTTON_1  = KeyEvent.VK_1;
  int BUTTON_2  = KeyEvent.VK_2;
  int BUTTON_3  = KeyEvent.VK_3;
  int BUTTON_4  = KeyEvent.VK_4;
  int BUTTON_5  = KeyEvent.VK_5;
  int BUTTON_6  = KeyEvent.VK_6;
  int BUTTON_7  = KeyEvent.VK_7;
  int BUTTON_8  = KeyEvent.VK_8;
  int BUTTON_9  = KeyEvent.VK_9;

  boolean isPressed(int keyCode, boolean withTimer);

  boolean isPressed(int keyCode);

  boolean isReleased(int keyCode);

}
