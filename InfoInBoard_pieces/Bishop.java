package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;

import java.util.HashSet;

public class Bishop extends Piece {
    PossibleMovementHelper possibleMovementHelper;
    public Bishop(boolean isWhite) {
        super(isWhite);
        possibleMovementHelper = new PossibleMovementHelper();
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♗";
        }
        return "♝";
    }


    @Override
    public HashSet possibleMovement(int fromX, int fromY, Pieces pieces) {
        return possibleMovementHelper.possibleMovementBishop(fromX, fromY, getIsWhite(), pieces);
    }

    public String getClassName() {
        return "Bishop";
    }


}
