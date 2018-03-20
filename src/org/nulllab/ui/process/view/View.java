package org.nulllab.ui.process.view;

import org.nulllab.nullengine.core.graphics.Renderable;

import java.awt.*;
import java.util.Map;

public interface View<V extends View, M extends Map<String, V>> extends Renderable<Graphics2D> {

  public V getParent();

  public void setParent(V view);

  public M getInnerViews();

  public V getInnerView(String name);

  public void registerInnerView(String name, V view);

}
