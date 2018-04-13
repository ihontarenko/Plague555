package org.nulllab.nullengine.core.common.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader extends FileResourceLoader {

  public ImageLoader(String filepath) {
    super(filepath);
  }

  public BufferedImage load() {
    BufferedImage bufferedImage = null;

    try {
      bufferedImage = ImageIO.read(getFileStream());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return bufferedImage;
  }

}
