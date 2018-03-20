package org.nulllab.nullengine.core.common.resource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader extends FileResourceLoader {

  public PropertiesLoader(String filepath) {
    super(filepath);
  }

  public Properties load() throws IOException {
    Properties properties = new Properties();
    properties.load(getFileStream());

    return properties;
  }

}
