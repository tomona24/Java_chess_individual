package InfoInBoard_pieces;

public class Position {
    private int x;
    private int y;

    public Position (int x, int y) throws Exception {
        this.x = x;
        this.y = y;
    }

    // getter
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    // setter
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }


}
