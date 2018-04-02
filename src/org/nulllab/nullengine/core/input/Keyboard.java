package org.nulllab.nullengine.core.input;

import org.nulllab.nullengine.core.common.time.Timer;

import javax.swing.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Keyboard extends JComponent implements Input {

  private int       length     = 256;
  private boolean[] keyCodeMap = new boolean[length];
  private Timer     timer      = new Timer(Timer.Factor.MILLI, 500D);

  public Keyboard() {
    InputMap  inputMap  = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = this.getActionMap();

    for (int i = 0; i < keyCodeMap.length; i++) {
      final int keyCode = i;

      inputMap.put(KeyStroke.getKeyStroke(i, 0, false), i);
      inputMap.put(KeyStroke.getKeyStroke(i, 0, true), ~i);

      actionMap.put(i, new AbstractAction() {
        public void actionPerformed(ActionEvent actionEvent) {
          Keyboard.this.keyCodeMap[keyCode] = true;
        }
      });

      actionMap.put(~i, new AbstractAction() {
        public void actionPerformed(ActionEvent actionEvent) {
          Keyboard.this.keyCodeMap[keyCode] = false;
        }
      });
    }
  }

  public Timer getTimer() {
    return timer;
  }

  @Override
  public int getPressed() {
    int pressedKey = 0;

    for (int keyCode = 0; keyCode < length; keyCode++) {
      if (isPressed(keyCode)) {
        pressedKey = keyCode;
        break;
      }
    }

    return pressedKey;
  }

  @Override
  public boolean isPressed(int keyCode, boolean withTimer) {
    boolean isPressed = this.keyCodeMap[keyCode];

    if (withTimer) {
      isPressed = isPressed && timer.isElapsedThenPurge();
    }

    return isPressed;
  }

  @Override
  public boolean isPressed(int keyCode) {
    return isPressed(keyCode, false);
  }

  @Override
  public boolean isReleased(int keyCode) {
    return isReleased(keyCode, false);
  }

  @Override
  public boolean isReleased(int keyCode, boolean withTimer) {
    boolean isReleased = !this.keyCodeMap[keyCode];

    if (withTimer) {
      isReleased = isReleased && timer.isElapsedThenPurge();
    }

    return isReleased;
  }

}
