package org.ionull.sorrowland.core.renderer;

import org.ionull.sorrowland.core.common.Renderable;

import java.util.Map;

public interface Renderer<R extends Renderer, M extends Map<String, R>> extends Renderable {

  public R getParent();

  public void setParent(R renderer);

  public M getInnerRenderers();

  public R getInnerRenderer(String name);

  public void registerInnerRenderer(String name, R renderer);

}
