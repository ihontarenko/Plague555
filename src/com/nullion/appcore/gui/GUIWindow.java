package com.nullion.appcore.gui;

import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.gui.canvas.GUICanvas;

import java.awt.*;

public class GUIWindow implements Initializable {

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
    GUICanvas canvas = new GUICanvas();
    canvas.setSize(getWidth(), getHeight());

    frame = new GUIFrame();
    frame.setLayout(new BorderLayout());
    frame.setSize(getWidth(), getHeight());
    frame.setCanvas(canvas);
    frame.initialize();

    canvas.initialize();
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      this.createFrame();
      this.isInitialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  public void swapBuffer() {
    getMainFrame().getCanvas().swapBuffer();
  }

  public void clearFrame() {
    getMainFrame().getCanvas().clearFrame();
  }

  public void setTitlePrefix(String title) {
    this.title = title;
  }

  public void setTitle(String title) {
    this.getMainFrame().setTitle(String.format("%s [%s]", this.title, title));
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

  public GUICanvas getCanvas() {
    return getMainFrame().getCanvas();
  }

  public Graphics2D getG2D() {
    return (Graphics2D)getCanvas().getG2D();
  }

  public String getTitle() {
    return title;
  }

}
