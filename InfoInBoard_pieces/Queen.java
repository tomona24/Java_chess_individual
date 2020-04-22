package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;

import java.util.ArrayList;
import java.util.HashSet;

public class Queen extends Piece {
    PossibleMovementHelper possibleMovementHelper;

    public Queen(boolean isWhite) {
        super(isWhite);
        this.possibleMovementHelper = new PossibleMovementHelper();
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♕";
        }
        return "♛";
    }


    @Override
    public HashSet possibleMovement(int fromX, int fromY, Pieces pieces) {
        HashSet<int[]> list = new HashSet<>();
        list.addAll(possibleMovementHelper.possibleMovementBishop(fromX, fromY, getIsWhite(), pieces));
        list.addAll(possibleMovementHelper.possibleMovementRook(fromX, fromY, getIsWhite(), pieces));
        return list;
    }
    public String getClassName() {
        return "Queen";
    }

}
