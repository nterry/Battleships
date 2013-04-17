package models;

public class Ship {
    private int size;
    private boolean isVertical;
    private boolean isPlaced;
    private Space placement;

    public Ship(int size, boolean isVertical) {
        this.size = size;
        this.isVertical = isVertical;
    }

    public int GetSize() {
        return size;
    }

    public boolean IsHorizontal() {
        return isVertical;
    }

    public void Place(Space placement) {
        isPlaced = true;
        this.placement = placement;
    }
}
