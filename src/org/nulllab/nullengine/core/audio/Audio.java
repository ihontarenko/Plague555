package org.nulllab.nullengine.core.audio;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.common.resource.AudioLoader;
import org.nulllab.nullengine.core.common.time.Timer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("unused")
public class Audio implements Initializable {

  private String      name;
  private AudioLoader loader;
  private Clip        clip;
  private Timer       timer;

  public Audio(String name, String filepath) {
    this(filepath);
    this.timer = new Timer(.5F);
    this.name = name;

    initialize();
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

  public Timer getTimer() {
    return timer;
  }

  public void setVolume(float volumeValue) {
    FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    volume.setValue(Math.max(Math.min(volume.getMaximum(), volumeValue), volumeValue));
  }

  public void timerLoop() {
    if (timer.isElapsedThenPurge()) {
      play();
    }
  }

  public void play() {
    if (clip.isRunning()) {
      stop();
    }

    reset();
    clip.start();
  }

  public void loop(int start, int end) {
    clip.setLoopPoints(start, end);
    loop();
  }

  public void loop() {
    getClip().loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void stop() {
    if (clip.isRunning()) {
      clip.stop();
    }
  }

  public void reset() {
    clip.setFramePosition(0);
  }

  public void close() {
    if (isInitialized()) {
      clip.close();
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
