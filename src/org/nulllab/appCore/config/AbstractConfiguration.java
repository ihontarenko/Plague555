package org.nulllab.appCore.config;

import org.nulllab.appCore.common.Initializable;
import org.nulllab.appCore.common.resource.PropertiesLoader;

import java.io.IOException;
import java.util.Properties;

public class AbstractConfiguration implements Initializable {

  private Properties properties;
  private String     propertiesFilename;

  public AbstractConfiguration() {}

  public AbstractConfiguration(String propertiesFilename) {
    this.propertiesFilename = propertiesFilename;
  }

  public AbstractConfiguration(Properties properties) {
    this.properties = properties;
  }

  public Properties getProperties() {
    return properties;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  public String getProperty(String name, String defaultValue) {
    return getProperties().getProperty(name, defaultValue);
  }

  public String getProperty(String name) {
    return getProperty(name, null);
  }

  @Override
  public boolean isInitialized() {
    return null != properties;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      try {
        properties = new PropertiesLoader(propertiesFilename).load();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void reinitialize() {
    // do nothing...
  }

}
