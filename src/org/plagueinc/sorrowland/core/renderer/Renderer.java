package org.plagueinc.sorrowland.core.renderer;

import org.plagueinc.sorrowland.core.common.Drawable;

import java.util.Map;

public interface Renderer<R extends Renderer, M extends Map<String, R>> extends Drawable {

  public R getParent();

  public void setParent(R renderer);

  public M getInnerRenderers();

  public R getInnerRenderer(String name);

  public void registerInnerRenderer(String name, R renderer);

}
