package org.plagueinc.sorrowland.gui;

import org.plagueinc.sorrowland.core.common.ProxyInterface;

import javax.swing.*;
import java.awt.*;

public class GUIFrame extends JFrame implements ProxyInterface {

  private boolean isInitialized = false;

  public void updateUI() {
    invalidate();
    validate();
    repaint();
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      setResizable(false);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);

      isInitialized = true;
    }
  }
}
