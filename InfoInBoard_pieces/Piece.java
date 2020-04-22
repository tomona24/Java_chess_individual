package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;
import java.util.HashSet;

public abstract class Piece {
    private boolean isWhite;

    // constructor
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    // getters

    public boolean getIsWhite() {
        return isWhite;
    }
    public abstract String getPiece();

    public abstract HashSet possibleMovement(int fromX, int fromY, Pieces pieces);

    @Override
    public boolean equals(Object obj) {
        if (((Piece) obj).getIsWhite() == getIsWhite()) {
            return true;
        }
        return false;
    }

    public abstract String getClassName();
}

