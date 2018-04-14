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

  public Audio(String name, String filepath, double interval) {
    this.timer = new Timer(interval);
    this.loader = new AudioLoader(filepath);
    this.name = name;
    initialize();
  }

  public Audio(String filepath) {
    this(null, filepath, 1D);
  }

  public Audio(String filepath, double interval) {
    this(null, filepath, interval);
  }

  public Audio(String name, String filepath) {
    this(name, filepath, 1D);
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
    FloatControl volume  = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    float        minimum = volume.getMinimum();
    float        maximum = volume.getMaximum();
    float        value   = Math.max(Math.min(volumeValue, maximum), minimum);

    volume.setValue(value);
  }

  public void loop() {
    stop();
    reset();
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void replay() {
    if (timer.isElapsedThenPurge()) play();
  }

  public void play() {
    stop();
    reset();
    while (!clip.isRunning()) clip.start();
  }

  public void stop() {
    if (clip.isRunning()) clip.stop();
  }

  public void reset() {
    clip.setFramePosition(0);
  }

  public void close() {
    if (isInitialized()) clip.close();
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
