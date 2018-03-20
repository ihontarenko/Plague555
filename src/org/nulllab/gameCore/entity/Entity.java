package org.nulllab.gameCore.entity;


import org.nulllab.gameCore.geometry.Bound2D;
import org.nulllab.gameCore.geometry.Vector2D;
import org.nulllab.gameCore.geometry.Object2D;

abstract public class Entity<T extends Entity> extends Object2D {

  protected int width = 0;
  protected int height = 0;
  protected Vector2D    position;
  protected Vector2D    velocity;
  protected Bound2D     bounds;
  protected EntityState state;

  public Entity(int x, int y, int width, int height, Vector2D position, Vector2D velocity, Bound2D bound2D) {
    super(x, y, width, height);
    this.bounds = bound2D;
    this.velocity = velocity;
    this.state = new EntityState();
  }

  public Vector2D position() {
    return this.position;
  }

  public Vector2D velocity() {
    return this.velocity;
  }

  public Bound2D bounds() {
    return bounds;
  }

  public EntityState state() {
    return this.state;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof Entity
        && this.velocity().equals(((Entity) object).velocity())
        && this.position().equals(((Entity) object).position());
  }

  abstract public void move(float elapsedTime);

  abstract public boolean colliding(T entity);

  @Override
  public String toString() {
    return String.format("%s: getX: %s, getY: %s, size: %sx%s", this.getClass().getSimpleName(), getX(), getY(), getWidth(), getHeight());
  }

}
