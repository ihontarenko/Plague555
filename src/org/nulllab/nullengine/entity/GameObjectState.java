package org.nulllab.nullengine.entity;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.Renderable;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.loop.Updateable;

public interface GameObjectState extends Renderable<Canvas>, Updateable {

  void entryAction(GameObject gameObject);

  GameObjectState handle(GameObject gameObject, Input input);

}
