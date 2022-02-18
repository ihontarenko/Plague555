package org.borisovich.core.openworld.world;

import org.borisovich.core.core.event.Event;
import org.borisovich.core.core.event.Observer;
import org.borisovich.core.openworld.character.Character;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.component.physics.CameraPhysics;

public class Camera extends GameObject {

  private Observer observer;

  public Camera(int x, int y, int width, int height) {
    super(x, y, width, height);

    this.observer = new CameraObserver();

    setPhysics(new CameraPhysics(this));
  }

  public Observer getObserver() {
    return observer;
  }

  public void setObserver(Observer observer) {
    this.observer = observer;
  }

  public class CameraObserver extends Observer<Character> {
    @Override
    public void onNotify(Character observable, Event event) {
      getPhysics().toCenter(observable.getCentreX(), observable.getCentreY());
    }
  }

}
