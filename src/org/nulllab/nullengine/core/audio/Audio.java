package org.nulllab.nullengine.core.audio;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.common.resource.AudioLoader;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.Objects;

public class Audio implements Initializable {

  private String      name;
  private AudioLoader loader;
  private Clip        clip;

  public Audio(String name, String filepath) {
    this(filepath);
    this.name = name;
  }

  public Audio(String filepath) {
    this.loader = new AudioLoader(filepath);
  }

  public AudioLoader getLoader() {
    return loader;
  }

  public Clip getClip() {
    return clip;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void play() {
    initialize();

    Clip clip = getClip();

    if (!clip.isRunning()) {
      getClip().start();
    }
  }

  public void stop() {
    initialize();

    Clip clip = getClip();

    if (clip.isRunning()) {
      getClip().stop();
    }
  }

  public void reset() {
    initialize();
    getClip().setFramePosition(0);
  }

  public void close() {
    if (isInitialized()) {
      getClip().close();
    }
  }

  @Override
  public boolean isInitialized() {
    return !Objects.isNull(this.clip);
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      try {
        clip = AudioSystem.getClip();
        clip.open(getLoader().load());
      } catch (LineUnavailableException | IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void reinitialize() {
    // do nothing...
  }
}
