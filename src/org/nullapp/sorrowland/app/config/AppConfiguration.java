package org.nullapp.sorrowland.app.config;

import org.nullapp.appCore.config.AbstractConfiguration;

import java.util.Properties;

public class AppConfiguration extends AbstractConfiguration {

  public AppConfiguration(String propertiesFilename) {
    super(propertiesFilename);
  }

  public AppConfiguration(Properties properties) {
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
