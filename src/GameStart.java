import org.nulllab.nullengine.component.InputComponent;
import org.nulllab.nullengine.entity.Monster;
import org.nulllab.sorrowland.app.GameLoop;

public class GameStart {

  public static void main(String[] args) {

    Monster monster = new Monster();

    monster.update(100f);

//    new GameLoop().start();
  }

}