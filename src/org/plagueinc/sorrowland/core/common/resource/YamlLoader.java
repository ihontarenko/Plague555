package org.plagueinc.sorrowland.core.common.resource;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;

public class YamlLoader extends FileResourceLoader {

  public YamlLoader(String filepath) {
    super(filepath);
  }

  public Object load() throws IOException {
    Yaml yaml = new Yaml();

    return yaml.load(getFileStream());
  }

}
