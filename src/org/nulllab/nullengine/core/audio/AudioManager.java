package org.nulllab.nullengine.core.audio;

import org.nulllab.nullengine.core.container.ObjectManager;

public class AudioManager extends ObjectManager<Audio> {

  public void addAudio(Audio audio) {
    setObject(audio.getName(), audio);
  }

  public void addAudio(String name, Audio audio) {
    setObject(name, audio);
  }

}
