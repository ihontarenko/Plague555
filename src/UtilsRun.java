import org.plagueinc.sl.core.spatialhash.SpatialHash;

import java.awt.*;

public class UtilsRun {

  public static void main(String[] args) {
    SpatialHash spatialHash = new SpatialHash();
    Rectangle rectangle = new Rectangle(150, 250, 50, 50);
    System.out.println(spatialHash.getHash(rectangle));
  }

}
