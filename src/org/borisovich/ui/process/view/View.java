package org.borisovich.ui.process.view;

import org.borisovich.core.core.graphics.Canvas;
import org.borisovich.core.core.graphics.Renderable;

import java.util.Map;

public interface View<V extends View, M extends Map<String, V>> extends Renderable<Canvas> {

  public V getParent();

  public void setParent(V view);

  public M getInnerViews();

  public V getInnerView(String name);

  public void registerInnerView(String name, V view);

}
