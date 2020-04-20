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

    public ArrayList possibleMovement(int fromX, int fromY, Pieces pieces) {

        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(((Piece)obj).getIsWhite() == getIsWhite()) {
            return true;
        }
        return false;
    }


}
