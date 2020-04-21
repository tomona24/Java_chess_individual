package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♙";
        }
        return "♟";
    }


    @Override
    public ArrayList possibleMovement(int fromX, int fromY, Pieces pieces) {
        ArrayList<int[]> possibilities = new ArrayList<>();
        if (getIsWhite()) {
            if (fromX > 0 && fromY < 7) {
                Piece frontLeft = pieces.getPieces()[fromX - 1][fromY + 1];
                if (frontLeft != null && !frontLeft.getIsWhite()) {
                    possibilities.add(new int[]{fromX - 1, fromY + 1});
                }
            }
            if (fromX < 7 && fromY < 7) {
                Piece frontRight = pieces.getPieces()[fromX + 1][fromY + 1];
                if (frontRight != null && !frontRight.getIsWhite()) {
                    possibilities.add(new int[]{fromX + 1, fromY + 1});
                }
            }
            if (fromX < 8 && fromY < 7) {
                Piece front = pieces.getPieces()[fromX][fromY + 1];
                if (front == null) {
                    possibilities.add(new int[]{fromX, fromY + 1});
                    if (fromY == 1 && pieces.getPieces()[fromX][fromY + 2] == null) {
                        possibilities.add(new int[]{fromX, fromY + 2});
                    }
                }
            }
        } else {
            // x = 2, x = 6
            if (fromX > 0 && fromY > 0) {
                Piece frontLeft = pieces.getPieces()[fromX - 1][fromY - 1];

                if ((fromX > 1) && (frontLeft != null) && frontLeft.getIsWhite()) {
                    possibilities.add(new int[]{fromX - 1, fromY - 1});
                }
            }
            if (fromX < 7 && fromY > 0) {
                Piece frontRight = pieces.getPieces()[fromX + 1][fromY - 1];
                if (fromX < 7 && frontRight != null && frontRight.getIsWhite()) {
                    possibilities.add(new int[]{fromX + 1, fromY - 1});
                }
            }
            if(fromY > 0) {
                Piece front = pieces.getPieces()[fromX][fromY - 1];
                if (front == null) {
                    possibilities.add(new int[]{fromX, fromY - 1});
                    if (fromY == 6 && pieces.getPieces()[fromX][fromY - 2] == null) {
                        possibilities.add(new int[]{fromX, fromY - 2});
                    }
                }
            }
        }
        return possibilities;
    }

}
