package org.nulllab.nullengine.core.common.resource;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

abstract public class FileResourceLoader <CacheObject> {

  protected Map<String, CacheObject> cacheObjectMap;
  private String                     filename;

  public FileResourceLoader() {
    this.cacheObjectMap = new HashMap<>();
  }

  public FileResourceLoader(String filepath) {
    this();
    setFilename(filepath);
  }

  public InputStream getFileStream() {
    return getClass().getResourceAsStream(filename);
  }

  public URL getFileResource() {
    return getClass().getResource(filename);
  }

  public File getFileObject() {
    return new File(getFilename());
  }

  public InputStreamReader getReader() {
    return new InputStreamReader(getFileStream());
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

  public void setFilename(String filename) {
    this.filename = resolveName(filename);
  }

  private String resolveName(String filename) {
    if (!filename.startsWith("/")) {
      filename = String.format("/%s", filename);
    }

    return filename;
  }

}
