package InfoInBoard_pieces;

import java.util.ArrayList;

public abstract class Piece {
    private boolean isWhite;

    // constructor
    public Piece( boolean isWhite) {
        this.isWhite = isWhite;
    }

    // getters

    public boolean getIsWhite() {
        return isWhite;
    }

    //setter


    public void setColor(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract String getPiece();

    //    public abstract void canMove();
    public abstract ArrayList isValidMove(int fromX, int fromY);


    @Override
    public boolean equals(Object obj) {
        if(((Piece)obj).getIsWhite() == getIsWhite()) {
            return true;
        }
        return false;
    }


}
