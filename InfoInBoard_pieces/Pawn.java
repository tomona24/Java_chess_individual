package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;

import java.util.HashSet;

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
    public HashSet possibleMovement(int fromX, int fromY, Pieces pieces) {
        if (getIsWhite()) {
            return possibleMovementForWhite(fromX, fromY, pieces);
        } else {
            return possibleMovementForBlack(fromX, fromY, pieces);
        }
    }


    private HashSet possibleMovementForWhite(int fromX, int fromY, Pieces pieces) {
        HashSet<int[]> possibilities = new HashSet<>();
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

        // en passant
        if (fromY == 4) {
            if (checkRightTheEnPassant(fromX, fromY, pieces)) {
                possibilities.add(new int[]{fromX + 1, fromY + 1});
            }
            if (checkLeftTHeEnPassant(fromX, fromY, pieces)) {
                possibilities.add(new int[]{fromX - 1, fromY + 1});
            }

        }
        return possibilities;
    }


    private HashSet possibleMovementForBlack(int fromX, int fromY, Pieces pieces) {
        HashSet<int[]> possibilities = new HashSet<>();
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
        if (fromY > 0) {
            Piece front = pieces.getPieces()[fromX][fromY - 1];
            if (front == null) {
                possibilities.add(new int[]{fromX, fromY - 1});
                if (fromY == 6 && pieces.getPieces()[fromX][fromY - 2] == null) {
                    possibilities.add(new int[]{fromX, fromY - 2});
                }
            }
        }
        // en passant
        if (fromY == 3) {
            if (checkRightTheEnPassant(fromX, fromY, pieces)) {
                possibilities.add(new int[]{fromX + 1, fromY - 1});
            }
            if (checkLeftTHeEnPassant(fromX, fromY, pieces)) {
                possibilities.add(new int[]{fromX - 1, fromY - 1});
            }
        }
        return possibilities;
    }

    public boolean checkRightTheEnPassant(int fromX, int fromY, Pieces pieces) {
        if (getIsWhite()) {
            Piece enemyRight = pieces.getPieces()[fromX + 1][fromY];
            Piece enemyRightBack = pieces.getPieces()[fromX + 1][fromY + 1];
            if (enemyRightBack == null
                    && enemyRight != null
                    && enemyRight.getClassName().equals("Pawn")
                    && !enemyRight.getIsWhite()) {
                return true;
            }
        } else {
            Piece enemyRight = pieces.getPieces()[fromX + 1][fromY];
            Piece enemyRightBack = pieces.getPieces()[fromX + 1][fromY - 1];
            if (enemyRightBack == null
                    && enemyRight != null
                    && enemyRight.getClassName().equals("Pawn")
                    && enemyRight.getIsWhite()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeftTHeEnPassant(int fromX, int fromY, Pieces pieces) {
        if (getIsWhite()) {
            Piece enemyLeft = pieces.getPieces()[fromX - 1][fromY];
            Piece enemyLeftBack = pieces.getPieces()[fromX - 1][fromY + 1];
            if (enemyLeftBack == null
                    && enemyLeft != null
                    && enemyLeft.getClassName().equals("Pawn")
                    && !enemyLeft.getIsWhite()) {
                return true;
            }
        } else {
            Piece enemyLeft = pieces.getPieces()[fromX - 1][fromY];
            Piece enemyLeftBack = pieces.getPieces()[fromX - 1][fromY - 1];
            if (enemyLeftBack == null
                    && enemyLeft != null
                    && enemyLeft.getClassName().equals("Pawn")
                    && enemyLeft.getIsWhite()) {
                return true;
            }
        }
        return false;
    }

    public String getClassName() {
        return "Pawn";
    }

}
