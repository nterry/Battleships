package views.PlayerBoards;

import javafx.util.Pair;
import models.Player;
import models.Space;

import javax.swing.*;
import java.awt.*;


public class PlayerBoard extends JPanel {

    private Player player;
    private Space[][] spaces;

    public PlayerBoard(int boardSize, Player player) {
        super(new GridLayout(boardSize, boardSize, 4, 4));
        this.player = player;
        spaces = new Space[boardSize][boardSize];

        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j ++) {
                Space space = new Space(new Pair<Integer, Integer>(i, j));
                space.addActionListener(player);
                spaces[i][j] = space;
                add(space);
            }
        }
    }
}
