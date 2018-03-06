package org.plagueinc.sorrowland.core.common.resource;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.List;

public class YamlLoader extends FileResourceLoader {

  public YamlLoader(String filepath) {
    super(filepath);
  }

  public List<String> load() throws IOException {
    Yaml yaml new Yaml();
    yaml.load(get)

    return properties;
  }

}
