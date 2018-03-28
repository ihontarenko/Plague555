package org.nulllab.nullengine.core.graphics;

public interface Renderable<Graphics extends Canvas> {

  public void render(Graphics canvas);

}
