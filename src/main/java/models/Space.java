package models;

import javafx.util.Pair;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: nickiterry
 * Date: 4/16/13
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Space extends JButton {
    private Pair<Integer, Integer> spaceId;
    private boolean selected;

    public Space(Pair<Integer, Integer> spaceId) {
        super("");
        this.spaceId = spaceId;
        selected = false;
    }

    public Pair <Integer, Integer> GetSpaceId() {
        return spaceId;
    }

    public void Select() {
        selected = true;
        setEnabled(false);
    }

    public boolean IsSelected() {
        return selected;
    }
}
