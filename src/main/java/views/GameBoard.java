package views;

import javafx.util.Pair;
import models.DestroyerShip;
import models.Player;
import models.Ship;
import models.Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame implements ActionListener {

    private Player player;
    private Space[][] spaces;

    public GameBoard(Player player, int boardSize) {
        super();
        this.player = player;
        spaces = new Space[boardSize][boardSize];

        JPanel panel = new JPanel(new GridLayout(boardSize, boardSize));
        panel.setBounds(0, 0, 50*boardSize, 50*boardSize);
        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 50*boardSize, 50*boardSize);

        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j ++) {
                Space space = new Space(new Pair<Integer, Integer>(i, j));
                space.addActionListener(this);
                spaces[i][j] = space;
                panel.add(space);
            }
        }
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
                spaces[initialSpace.GetSpaceId().getKey()+(i * BooleanToInt(!ship.IsHorizontal()))][initialSpace.GetSpaceId().getValue()+(i * BooleanToInt(ship.IsHorizontal()))].Select();
            }
        }
        ship.Place(initialSpace);
    }

    private boolean CheckBounds(Space initialSpace, Ship ship) {
        for (int i=0; i<ship.GetSize(); i++) {
            try {
                if (spaces[initialSpace.GetSpaceId().getKey()+(i * BooleanToInt(!ship.IsHorizontal()))][initialSpace.GetSpaceId().getValue()+(i * BooleanToInt(ship.IsHorizontal()))].IsSelected()) {
                    return false;
                }
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
