package org.nulllab.nullengine.openworld.map;

import org.nulllab.nullengine.core.common.resource.FileResourceLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WorldMapLoader extends FileResourceLoader {

  public WorldMapLoader(String filepath) {
    super(filepath);
  }

  public void toMapData(WorldMapData mapData) {
    Scanner      scanner = new Scanner(getFileStream());

    while (scanner.hasNextLine()) {

      String line = scanner.nextLine();

      if (line.startsWith("//") || line.isEmpty()) {
        continue;
      }

      if (line.startsWith("Size")) {
        List<Integer> size = processIntegers(scanner.nextLine());
        mapData.setTileSize(size.get(2));
        mapData.setWidth(size.get(0));
        mapData.setHeight(size.get(1));
        continue;
      }

      if (line.startsWith("Map")) {
        continue;
      }

      processTileData(line, mapData);
    }
  }

  private void processTileData(String line, WorldMapData data) {
    String[]      strings   = line.split(" ");
    List<Integer> integers  = processIntegers(Arrays.copyOfRange(strings, 1, strings.length));
    String        spriteID  = strings[0];
    int           positionX = integers.get(0);
    int           positionY = integers.get(1);
    int           layer     = integers.get(2);
    boolean       isSolid   = (integers.get(3) != 0);

    WorldMapData.Tile tile = data.new Tile(positionX, positionY, layer, isSolid, spriteID);
    data.addTile(tile);
  }

  private List<Integer> processIntegers(String line) {
    return processIntegers(line.split(" "));
  }

  private List<Integer> processIntegers(String[] strings) {
    return Arrays.stream(strings).map(Integer::valueOf).collect(Collectors.toList());
  }

}
