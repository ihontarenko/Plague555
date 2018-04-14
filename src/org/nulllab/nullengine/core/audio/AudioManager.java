package org.nulllab.nullengine.core.audio;

import org.nulllab.nullengine.core.container.ObjectManager;

public class AudioManager extends ObjectManager<Audio> {

  public void addAudio(Audio audio) {
    setObject(audio.getName(), audio);
  }

  public void addAudio(String name, Audio audio) {
    setObject(name, audio);
  }

  public void addAudio(String name, String filepath) {
    addAudio(new Audio(name, filepath));
  }

  public void addAudio(String name, String filepath, double interval) {
    addAudio(new Audio(name, filepath, interval));
  }

  public void play(String name) {
    getObject(name).play();
  }

  public void loop(String name) {
    getObject(name).loop();
  }

  public void replay(String name) {
    getObject(name).replay();
  }

  public void stop(String name) {
    getObject(name).stop();
  }

}
