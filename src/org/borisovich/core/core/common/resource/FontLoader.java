package org.borisovich.core.core.common.resource;

import java.awt.*;

public class FontLoader extends FileResourceLoader<Font> {

  public FontLoader(String filepath) {
    super(filepath);
  }

  public Font load() {
    if (!hasCache(getFilename())) {
      try {
        Font font = Font.createFont(Font.TRUETYPE_FONT, getFileStream());
        setCache(getFilename(), font);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return getCache(getFilename());
  }

}
