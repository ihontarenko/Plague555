package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.common.resource.FileResourceLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapParser extends FileResourceLoader {

  public MapParser(String filepath) {
    super(filepath);
  }

  public WorldMapData loadMap() {

    WorldMapData mapData = new WorldMapData();
    Scanner      scanner = new Scanner(getFileStream());

    while (scanner.hasNextLine()) {

      String line = scanner.nextLine();

      if (line.startsWith("//") || line.isEmpty()) {
        continue;
      }

      if (line.startsWith("Size")) {
        Integer[] size = processCoordinates(scanner.nextLine());
        mapData.setWidth(size[0]);
        mapData.setHeight(size[1]);
        continue;
      }

      if (line.startsWith("Fill")) {
        processFill(scanner.nextLine());
        continue;
      }

      if (line.startsWith("Terrain")) {
        continue;
      }

      processTerrain(line);
    }

    return mapData;
  }

  private Integer[] processCoordinates(String line) {
    String[] size = line.split(":");

    return new Integer[]{Integer.valueOf(size[0]), Integer.valueOf(size[1])};
  }

  private void processFill(String line) {
    System.out.println("processFill" + line);
  }

  private Map<Integer[], Map<Integer, Integer[]>> processTerrain(String line) {
    Map<Integer[], Map<Integer, Integer[]>> terrain = new HashMap<>();

    if (line.contains(";")) {
      String[]                splitted    = line.split(";");
      Integer[]               coordinates = processCoordinates(splitted[0]);
      Map<Integer, Integer[]> layers      = processLayers(splitted[1]);
      terrain.put(coordinates, layers);
    }

    return terrain;
  }

  private Map<Integer, Integer[]> processLayers(String line) {
    Map<Integer, Integer[]> layers = new HashMap<>();
    String[]                tiles;

    if (line.contains("/")) {
      tiles = line.split("/");
    } else {
      tiles = new String[]{line};
    }

    for (String tile : tiles) {

    }

    return layers;
  }

}
