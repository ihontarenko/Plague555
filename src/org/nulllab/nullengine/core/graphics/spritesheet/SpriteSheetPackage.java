package org.nulllab.nullengine.core.graphics.spritesheet;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.common.resource.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

abstract public class SpriteSheetPackage implements Initializable {

  private String                   filename;
  private Map<String, SpriteSheet> spriteSheets;

  public SpriteSheetPackage(String filename) {
    this.filename = filename;
    this.spriteSheets = new HashMap<>();
  }

  public SpriteSheet getSpriteSheet(String name) {
    return spriteSheets.get(name);
  }

  public Map<String, SpriteSheet> getSpriteSheets() {
    return spriteSheets;
  }

  @Override
  public boolean isInitialized() {
    return spriteSheets.size() > 0;
  }

  @Override
  public void initialize() {
    InputStream   inputStream   = new ImageLoader(getFilename()).getFileStream();
    BufferedImage bufferedImage = null;

    try {
      bufferedImage = ImageIO.read(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (SpriteSheetParameters parameters : getSpriteSheetParameters()) {
      SpriteSheet sheet = new SpriteSheet(bufferedImage,
          parameters.getSizeX(), parameters.getSizeY(),
          parameters.getOffsetX(), parameters.getOffsetY(),
          parameters.getCountX(), parameters.getCountY()
      );
      spriteSheets.put(parameters.getName(), sheet);
    }
  }

  @Override
  public void reinitialize() {

  }

  public String getFilename() {
    return filename;
  }

  public String getPackageUniqueName() {
    return getClass().getSimpleName();
  }

  abstract public SpriteSheetParameters[] getSpriteSheetParameters();

}
