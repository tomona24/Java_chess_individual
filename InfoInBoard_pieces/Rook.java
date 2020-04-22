package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;

import java.util.HashSet;

public class Rook extends Piece {
    PossibleMovementHelper possibleMovementHelper;

    public Rook(boolean isWhite) {
        super(isWhite);
        this.possibleMovementHelper = new PossibleMovementHelper();
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♖";
        }
        return "♜";
    }

    @Override
    public HashSet possibleMovement(int fromX, int fromY, Pieces pieces) {
        return possibleMovementHelper.possibleMovementRook(fromX, fromY, getIsWhite(), pieces);
    }

    public String getClassName() {
        return "Rook";
    }
}
