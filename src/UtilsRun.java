
import org.plagueinc.sorrowland.core.intersection.spatialhash.SpatialHash;

import java.awt.*;

public class UtilsRun {

  public static void main(String[] args) {
    SpatialHash spatialHash = new SpatialHash();
    Rectangle   rectangle   = new Rectangle(150, 250, 50, 50);
    System.out.println(spatialHash.getHash(rectangle));

    System.out.println(4 >> 5);
    System.out.println(4 >> 5);

    System.out.println(4 + 100 >> 5);
    System.out.println(4 + 100 >> 5);

  }

}
