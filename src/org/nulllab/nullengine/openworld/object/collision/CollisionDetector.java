package org.nulllab.nullengine.openworld.object.collision;

import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.physics.Physics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollisionDetector {

  private SpatialHash<GameObject> spatialHash;

  public CollisionDetector() {
    this.spatialHash = ServiceLocator.getInstance().getWorld().getSpatialHash();
  }

  public List<GameObject> getNearestObjectsFor(GameObject object) {
    Physics          physics        = object.getPhysics();
    List<GameObject> nearestObjects = new ArrayList<>(spatialHash.retrieve(physics.getSpatialBounds()));

    Collections.sort(nearestObjects);

    return nearestObjects;
  }

  public List<GameObject> getNearestSolidObjectsFor(GameObject object) {
    return getNearestObjectsFor(object).stream().filter(GameObject::isSolid).collect(Collectors.toList());
  }

  public boolean isCollidedWith(GameObject targetObject, GameObject solidObject) {
    return targetObject.getPhysics().getInnerBound().intersects(solidObject.getPhysics().getInnerBound());
  }

  public boolean isCollidedWith(GameObject targetObject, List<GameObject> solidObjects) {
    boolean isCollided = false;

    for (GameObject solidObject : solidObjects) {
      isCollided = isCollided || isCollidedWith(targetObject, solidObject);
    }

    return isCollided;
  }

  public boolean isCollidedWithNearest(GameObject object) {
    return isCollidedWith(object, getNearestObjectsFor(object));
  }

  public boolean isCollidedWithNearestSolid(GameObject object) {
    return isCollidedWith(object, getNearestSolidObjectsFor(object));
  }

  public boolean isOutOfBounds(Bounds2D inner, Bounds2D outer) {
    return !outer.inBounds(inner);
  }

  public boolean isOutOfBoundsX(Bounds2D inner, Bounds2D outer) {
    return !outer.inBoundsX(inner);
  }

  public boolean isOutOfBoundsY(Bounds2D inner, Bounds2D outer) {
    return !outer.inBoundsY(inner);
  }

}
