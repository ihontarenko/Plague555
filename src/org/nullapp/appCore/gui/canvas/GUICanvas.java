package org.nullapp.appCore.gui.canvas;

import org.nullapp.appCore.common.Initializable;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class GUICanvas extends Canvas implements Initializable {

  private BufferedImage  image;
  private BufferStrategy strategy;
  private int[]          data;
  private Graphics2D     g2d;
  private boolean        isInitialized;

  private int defaultColor = 0xff000000;

  public GUICanvas() {
    this(400, 300);
  }

  public GUICanvas(int width, int height) {
    super();
    setSize(width, height);
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
      data = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
      g2d = (Graphics2D) image.getGraphics();

      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      createBufferStrategy(4);
      strategy = getBufferStrategy();

      isInitialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

  public void swapBuffer() {
    BufferStrategy strategy = getStrategy();
    strategy.getDrawGraphics().drawImage(getImage(), 0, 0, null);
    strategy.show();
  }

  public void clearFrame() {
    Arrays.fill(data, getDefaultColor());
  }

  public BufferedImage getImage() {
    return image;
  }

  public BufferStrategy getStrategy() {
    return strategy;
  }

  public int[] getData() {
    return data;
  }

  public Graphics2D getG2D() {
    return g2d;
  }

  public int getDefaultColor() {
    return defaultColor;
  }

  public void setDefaultColor(int defaultColor) {
    this.defaultColor = defaultColor;
  }

}
