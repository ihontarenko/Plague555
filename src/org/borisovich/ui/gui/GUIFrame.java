package org.borisovich.ui.gui;

import org.borisovich.core.core.common.Initializable;
import org.borisovich.ui.gui.canvas.GUICanvas;

import javax.swing.*;

public class GUIFrame extends JFrame implements Initializable {

  private boolean   isInitialized;
  private GUICanvas canvas;

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
//      JScrollPane scrollPane = new JScrollPane(canvas);
//      scrollPane.setSize(400, 500);
      getContentPane().add(canvas);
      setResizable(false);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      isInitialized = true;
    }
  }
  @Override
  public void reinitialize() {

  }


  public void setCanvas(GUICanvas canvas) {
    this.canvas = canvas;
  }

  public GUICanvas getCanvas() {
    return canvas;
  }

}
