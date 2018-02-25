import org.plagueinc.sorrowland.gui.GUIWindow;

public class StartLoop {

  public static void main(String[] args) {
    GUIWindow window = new GUIWindow(400, 500);
    window.initialize();
    window.swapBuffer();
  }

}