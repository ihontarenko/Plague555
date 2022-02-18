package org.borisovich.core.openworld.configuration;

import org.borisovich.core.core.common.resource.FileLoader;
import org.borisovich.core.core.common.resource.FileResourceLoader;
import org.borisovich.core.openworld.configuration.entities.ConfigEntity;

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

  @SuppressWarnings("unchecked")
  public <T extends ConfigEntity> T buildConfigurationEntity(String configurationFile, Class<? extends T> entityClass) {
    T                  entity       = createConfigurationEntity(configurationFile, entityClass);
    FileResourceLoader loader       = getLoader();

    if (entity.hasParent()) {
      String parentSource = String.format("%s/%s", loader.getFileObject().getParent(), entity.getParent());
      entity.overrideWith(buildConfigurationEntity(parentSource, entityClass));
    }

    return entity;
  }

  abstract public <T> T createConfigurationEntity(String configurationFile, Class<? extends T> entityClass);

}
