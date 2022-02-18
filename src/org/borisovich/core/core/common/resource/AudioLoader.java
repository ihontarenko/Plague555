package org.borisovich.core.core.common.resource;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AudioLoader extends FileResourceLoader {

  public AudioLoader(String filepath) {
    super(filepath);
  }

  public AudioInputStream load() {
    AudioInputStream audioInputStream = null;

    try {
      audioInputStream = AudioSystem.getAudioInputStream(getFileStream());
    } catch (UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }

    return audioInputStream;
  }

}
