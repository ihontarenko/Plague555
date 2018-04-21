package org.nulllab.nullengine.openworld.configuration.builder;

import com.google.gson.Gson;
import org.nulllab.nullengine.core.common.resource.FileResourceLoader;
import org.nulllab.nullengine.openworld.configuration.ConfigurationBuilder;

public class GoogleJsonBuilder extends ConfigurationBuilder {

  private Gson gson;

  public GoogleJsonBuilder() {
    super();
    this.gson = new Gson();
  }

  @Override
  public <T> T createConfigurationEntity(String configurationFile, Class<? extends T> entityClass) {
    FileResourceLoader loader = getLoader();

    loader.setFilename(configurationFile);

    return getGson().fromJson(loader.getReader(), entityClass);
  }

  public Gson getGson() {
    return gson;
  }

  public void setGson(Gson gson) {
    this.gson = gson;
  }
}
