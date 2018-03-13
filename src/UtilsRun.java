
import org.nullapp.sorrowland.core.geometry.intersection.spatialhash.SpatialHash;

import java.awt.*;

public class UtilsRun {

  public static void main(String[] args) {
    SpatialHash spatialHash = new SpatialHash();

    System.out.println(spatialHash.getHash(new Rectangle(750, 800, 1024, 1024)));
    System.out.println(spatialHash.getHash(new Rectangle(100, 100, 200, 200)));
    System.out.println(spatialHash.getHash(new Rectangle(0, 0, 400, 350)));

    int width = 1740;
    double pixels = Math.pow(2, SpatialHash.SHIFT);

    double cellA = width >> SpatialHash.SHIFT;
    double cellB = width / pixels;

    System.out.println(cellA);
    System.out.println(cellB);

  }

}
