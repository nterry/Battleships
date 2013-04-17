import models.Player;
import views.GameBoard;

/**
 * Created with IntelliJ IDEA.
 * User: nickiterry
 * Date: 4/16/13
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args) {
        new GameBoard(new Player(), 10);

    }
}
