package com.nullion.appcore.view;

import com.nullion.appcore.common.Renderable;

import java.util.Map;

public interface View<V extends View, M extends Map<String, V>> extends Renderable {

  public V getParent();

  public void setParent(V view);

  public M getInnerViews();

  public V getInnerView(String name);

  public void registerInnerView(String name, V view);

}
