package org.nulllab.nullengine.openworld.object.component.bounds;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;

import java.util.List;

public interface BoundsInterface {

  Bounds2D getOuterBounds();

  Bounds2D getInnerBound();

  Bounds2D getSpatialBounds();

  void setOuterBounds(Bounds2D bounds);

}
