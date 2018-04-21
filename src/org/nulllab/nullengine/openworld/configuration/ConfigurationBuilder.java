package org.nulllab.nullengine.openworld.configuration;

import org.nulllab.nullengine.core.common.resource.FileLoader;
import org.nulllab.nullengine.core.common.resource.FileResourceLoader;

abstract public class ConfigurationBuilder {

  private FileResourceLoader loader;

  public ConfigurationBuilder() {
    this.loader = new FileLoader();
  }

  public FileResourceLoader getLoader() {
    return loader;
  }

  public void setLoader(FileResourceLoader loader) {
    this.loader = loader;
  }

  abstract public <T> T createConfigurationEntity(String configurationFile, Class<? extends T> entityClass);

}
