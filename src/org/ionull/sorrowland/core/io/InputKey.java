package org.ionull.sorrowland.core.io;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InputKey extends JComponent {

  private boolean[] keyCodeMap = new boolean[256];

  public InputKey() {
    InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = this.getActionMap();

    for (int i = 0; i < keyCodeMap.length; i++) {
      inputMap.put(KeyStroke.getKeyStroke(i, 0, false), i);
      inputMap.put(KeyStroke.getKeyStroke(i, 0, true), ~i);

      actionMap.put(i, createAction(i, true));
      actionMap.put(~i, createAction(i, false));
    }
  }

  public boolean getKey(int keyCode) {
    return this.keyCodeMap[keyCode];
  }

  public boolean getUp() {
    return this.getKey(KeyEvent.VK_UP);
  }

  public boolean getDown() {
    return this.getKey(KeyEvent.VK_DOWN);
  }

  public boolean getLeft() {
    return this.getKey(KeyEvent.VK_LEFT);
  }

  public boolean getRight() {
    return this.getKey(KeyEvent.VK_RIGHT);
  }

  private AbstractAction createAction(int keyCode, boolean state) {
    return new AbstractAction() {
      public void actionPerformed(ActionEvent actionEvent) {
        InputKey.this.keyCodeMap[keyCode] = state;
      }
    };
  }

}
