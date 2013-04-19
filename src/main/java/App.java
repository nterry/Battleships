import models.Player;
import views.GameBoards.PvCGameBoard;

/**
 * Created with IntelliJ IDEA.
 * User: nickiterry
 * Date: 4/16/13
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args) {
        new PvCGameBoard(new Player(), 10);

    }
}
