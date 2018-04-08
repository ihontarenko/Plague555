package org.nulllab.nullengine.openworld.world;

import org.nulllab.nullengine.core.event.Event;
import org.nulllab.nullengine.core.event.Observer;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.object.MovableGameObject;

public class Camera extends MovableGameObject {

  private Observer observer;

  public Camera(int x, int y, int width, int height) {
    super(x, y, width, height);
    observer = new CameraObserver();
  }

  public Observer getObserver() {
    return observer;
  }

  public class CameraObserver extends Observer<Character> {
    @Override
    public void onNotify(Character observable, Event event) {
      Camera.this.toCenter(observable.getCentreX(), observable.getCentreY());
    }
  }

}
