package org.plagueinc.sorrowland.gui;

import org.plagueinc.sorrowland.core.common.ProxyInterface;
import org.plagueinc.sorrowland.gui.pane.MainMenuPane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class GUIWindow implements ProxyInterface {

  private boolean isInitialized = false;

  private int width;
  private int height;
  private GUIFrame frame;
  private Canvas content;
  private BufferedImage bufferedImage;
  private BufferStrategy bufferStrategy;
  private int[] bufferedData;
  private Graphics2D graphics2D;
  private String title;

  public GUIWindow(int width, int height) {
    this(width, height, GUIWindow.class.getCanonicalName());
  }

  public GUIWindow(int width, int height, String title) {
    this.width = width;
    this.height = height;
    this.title = title;
  }

  private void createFrame() {
    this.content = new Canvas();
    this.content.setSize(new Dimension(this.width, this.height));

    this.frame = new GUIFrame();
    this.frame.add(this.content);
    this.frame.initialize();
  }

  public void initialize() {
    if (!isInitialized()) {
      this.createFrame();

      this.bufferedImage  = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
      this.bufferedData   = ((DataBufferInt) this.bufferedImage.getRaster().getDataBuffer()).getData();
      this.graphics2D     = (Graphics2D) this.bufferedImage.getGraphics();

      this.graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      this.content.createBufferStrategy(3);
      this.bufferStrategy = this.content.getBufferStrategy();

      this.isInitialized = true;
    }
  }

  public boolean isInitialized() {
    return isInitialized;
  }

  public void swapBuffer() {
    this.bufferStrategy
        .getDrawGraphics()
        .drawImage(this.bufferedImage, 0, 0, null);
    this.bufferStrategy.show();
  }

  public void clearFrame() {
    Arrays.fill(this.bufferedData, 0xff000000);
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

  public Canvas getContent() {
    return content;
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public BufferStrategy getBufferStrategy() {
    return bufferStrategy;
  }

  public int[] getBufferedData() {
    return bufferedData;
  }

  public Graphics2D getGraphics2D() {
    return graphics2D;
  }

  public String getTitle() {
    return title;
  }

}
