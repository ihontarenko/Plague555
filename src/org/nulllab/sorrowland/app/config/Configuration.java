package org.nulllab.sorrowland.app.config;

import org.nulllab.nullengine.core.config.AbstractConfiguration;

import java.util.Properties;

public class Configuration extends AbstractConfiguration {

  public Configuration(String propertiesFilename) {
    super(propertiesFilename);
  }

  public Configuration(Properties properties) {
    super(properties);
  }

  public String getLogoPath() {
    return getProperty("sprites.logo");
  }

  public Integer getWidth() {
    return Integer.valueOf(getProperty("app.window.width"));
  }

  public Integer getHeight() {
    return Integer.valueOf(getProperty("app.window.height"));
  }

  public String getAppName() {
    return getProperty("app.name");
  }

  public String getAppVersion() {
    return getProperty("app.version");
  }

  public String getAppFullName() {
    return String.format("%s: %s", getAppName(), getAppVersion());
  }

}
