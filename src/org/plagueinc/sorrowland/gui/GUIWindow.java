package org.plagueinc.sorrowland.gui;

import org.plagueinc.sorrowland.core.common.ProxyInterface;
import org.plagueinc.sorrowland.gui.canvas.GUICanvas;
import org.plagueinc.sorrowland.gui.pane.MainMenuPane;

import javax.swing.*;
import java.awt.*;

public class GUIWindow implements ProxyInterface {

  private boolean isInitialized = false;

  private int      width;
  private int      height;
  private GUIFrame frame;
  private String   title;

  public GUIWindow(int width, int height) {
    this(width, height, GUIWindow.class.getSimpleName());
  }

  public GUIWindow(int width, int height, String title) {
    this.width = width;
    this.height = height;
    this.title = title;
  }

  private void createFrame() {
    GUIFrame guiFrame = new GUIFrame();
    GUICanvas canvas = new GUICanvas(getWidth(), getHeight());

    canvas.setDefaultColor(0xff00ccaa);
    canvas.setSize(100, 200);

    guiFrame.initialize();
    guiFrame.setSize(getWidth(), getHeight());
//    guiFrame.add(canvas);

//    canvas.initialize();
//    guiFrame.getCanvasCollection().put(GUIFrame.CANVAS_NAME, canvas);

    this.frame = guiFrame;
  }

  public void initialize() {
    if (!isInitialized()) {
      this.createFrame();
      this.isInitialized = true;
    }
  }

  public boolean isInitialized() {
    return isInitialized;
  }

  public void swapBuffer() {
    getMainFrame().getCanvasCollection().forEach((s, canvas) -> canvas.swapBuffer());
  }

  public void clearFrame() {
    getMainFrame().getCanvasCollection().forEach((s, canvas) -> canvas.clearFrame());
  }

  public void appendTitle(String title) {
    this.getMainFrame().setTitle(this.title + title);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public GUIFrame getMainFrame() {
    return frame;
  }

  public GUICanvas getMainCanvas() {
    return getMainFrame().getGUICanvas(GUIFrame.CANVAS_NAME);
  }

  public String getTitle() {
    return title;
  }

}
