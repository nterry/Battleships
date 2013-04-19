package views.GameBoards;

import javafx.util.Pair;
import models.DestroyerShip;
import models.Player;
import models.Ship;
import models.Space;
import views.GameBoards.GameBoard;
import views.PlayerBoards.PlayerBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PvCGameBoard extends GameBoard implements ActionListener {

    private JPanel container;
    private PlayerBoard myBoard;
    private PlayerBoard computerBoard;

    public PvCGameBoard(Player player, int boardSize) {
        super();

        container = new JPanel(new GridLayout(1, 2, 20, 20));

        myBoard = new PlayerBoard(boardSize, player);
        computerBoard = new PlayerBoard(boardSize, player);

        container.add(myBoard);
        container.add(computerBoard);

        add(container);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Space space = (Space)e.getSource();
        System.out.println(String.format("Selected space (%d, %d)", space.GetSpaceId().getKey(), space.GetSpaceId().getValue()));
        PlaceShip(space, new DestroyerShip(false));
    }

    private void PlaceShip(Space initialSpace, Ship ship) {
        if (CheckBounds(initialSpace, ship)) {
            for (int i=0; i<ship.GetSize(); i++) {
                //spaces[initialSpace.GetSpaceId().getKey()+(i * BooleanToInt(!ship.IsHorizontal()))][initialSpace.GetSpaceId().getValue()+(i * BooleanToInt(ship.IsHorizontal()))].Select();
            }
        }
        ship.Place(initialSpace);
    }

    private boolean CheckBounds(Space initialSpace, Ship ship) {
        for (int i=0; i<ship.GetSize(); i++) {
            try {
                //if (spaces[initialSpace.GetSpaceId().getKey()+(i * BooleanToInt(!ship.IsHorizontal()))][initialSpace.GetSpaceId().getValue()+(i * BooleanToInt(ship.IsHorizontal()))].IsSelected()) {
                    //return false;
                //}
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }
        return true;
    }

    private int BooleanToInt(boolean b) {
        if (b) return 1;
        else return 0;
    }
}
