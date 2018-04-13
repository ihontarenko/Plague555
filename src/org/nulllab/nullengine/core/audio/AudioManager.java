package org.nulllab.nullengine.core.audio;

import org.nulllab.nullengine.core.container.ObjectManager;

import javax.sound.sampled.Clip;

public class AudioManager extends ObjectManager<Audio> {

  public void addAudio(Audio audio) {
    setObject(audio.getName(), audio);
  }

  public void addAudio(String name, Audio audio) {
    setObject(name, audio);
  }

  public void play(String name) {
    getObject(name).play();
  }

  public void loop(String name, double interval) {
    Audio audio = getObject(name);
    audio.getTimer().setInterval(interval);
    audio.timerLoop();
  }

  public void loop(String name) {
    getObject(name).loop();
  }

  public void stop(String name) {
    getObject(name).stop();
  }

}
