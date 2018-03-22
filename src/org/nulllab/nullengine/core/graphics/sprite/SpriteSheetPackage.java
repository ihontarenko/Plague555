package org.nulllab.nullengine.core.graphics.sprite;

import org.nulllab.nullengine.core.common.Initializable;
import org.nulllab.nullengine.core.common.resource.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

abstract public class SpriteSheetPackage implements Initializable {

  private String            filename;
  private List<SpriteSheet> spriteSheets;

  public SpriteSheetPackage(String filename) {
    this.filename = filename;
    this.spriteSheets = new ArrayList<>();
  }

  public SpriteSheet getSpriteSheet(int index) {
    return spriteSheets.get(index);
  }

  public List<SpriteSheet> getSpriteSheets() {
    return spriteSheets;
  }

  @Override
  public boolean isInitialized() {
    return spriteSheets != null;
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
      spriteSheets.add(sheet);
    }
  }

  @Override
  public void reinitialize() {

  }

  public String getFilename() {
    return filename;
  }

  abstract public SpriteSheetParameters[] getSpriteSheetParameters();

}
