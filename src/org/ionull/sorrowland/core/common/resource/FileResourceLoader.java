package org.ionull.sorrowland.core.common.resource;

import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

abstract public class FileResourceLoader <CacheObject> {

  protected Map<String, CacheObject> cacheObjectMap;
  private String                     filename;

  public FileResourceLoader(String filepath) {
    this.filename = resolveName(filepath);
    this.cacheObjectMap = new HashMap<>();
  }

  public InputStream getFileStream() {
    return getClass().getResourceAsStream(filename);
  }

  public FileReader getFileReader() {
    return null;
  }

  public CacheObject getCache(String name) {
    return cacheObjectMap.get(name);
  }

  public void setCache(String name, CacheObject cacheObject) {
    cacheObjectMap.put(name, cacheObject);
  }

  public boolean hasCache(String name) {
    return cacheObjectMap.containsKey(name);
  }

  public String getFilename() {
    return filename;
  }

  private String resolveName(String filename) {
    if (!filename.startsWith("/")) {
      filename = String.format("/%s", filename);
    }

    return filename;
  }

}
