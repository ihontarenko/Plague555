package org.ionull.sorrowland.core.common.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader extends FileResourceLoader {

  public ImageLoader(String filepath) {
    super(filepath);
  }

  public BufferedImage load() throws IOException {
    return ImageIO.read(getFileStream());
  }

}
