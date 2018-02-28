package org.plagueinc.sorrowland.gui;

import org.plagueinc.sorrowland.core.common.ProxyInterface;
import org.plagueinc.sorrowland.gui.canvas.GUICanvas;

import javax.swing.*;

public class GUIFrame extends JFrame implements ProxyInterface {

  private boolean      isInitialized;
  private GUICanvas    canvas;

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  public void updateUI() {
    invalidate();
    validate();
    repaint();
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      getContentPane().add(canvas);
      setResizable(false);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      isInitialized = true;
    }
  }

  public void setCanvas(GUICanvas canvas) {
    this.canvas = canvas;
  }

  public GUICanvas getCanvas() {
    return canvas;
  }

}
