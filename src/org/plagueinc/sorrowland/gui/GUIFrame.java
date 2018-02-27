package org.plagueinc.sorrowland.gui;

import org.plagueinc.sorrowland.core.common.ProxyInterface;
import org.plagueinc.sorrowland.gui.canvas.GUICanvas;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GUIFrame extends JFrame implements ProxyInterface {

  final public static String CANVAS_NAME = "Main";

  private boolean                isInitialized;
  private Map<String, GUICanvas> canvasCollection;
  private JLayeredPane           panel;

  public GUIFrame() {
    canvasCollection = new HashMap<>();
  }

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
      panel = new JLayeredPane();
      panel.setLayout(null);
      getContentPane().add(panel);
      setResizable(false);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      isInitialized = true;
    }
  }

  public void addCanvas(String name, GUICanvas canvas) {
    panel.add(canvas, JLayeredPane.DRAG_LAYER);

    if (!isInitialized()) {
      initialize();
    }

    if (!canvas.isInitialized()) {
      canvas.initialize();
    }

    if (isInitialized()) {
      updateUI();
    }

    canvasCollection.put(name, canvas);
  }

  public GUICanvas getGUICanvas(String name) {
    return canvasCollection.get(name);
  }

  public Map<String, GUICanvas> getCanvasCollection() {
    return canvasCollection;
  }

}
