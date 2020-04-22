package InfoInBoard_pieces;

import InfoInBoard_board.Pieces;

import java.util.ArrayList;
import java.util.HashSet;

public class Knight extends Piece {


    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♘";
        }
        return "♞";
    }


    @Override
    public HashSet possibleMovement(int fromX, int fromY, Pieces pieces) {
        HashSet<int[]> list = new HashSet<>();
        int[][] allPossibilities = new int[][]{
                {fromX - 1, fromY + 2},
                {fromX - 1, fromY - 2},
                {fromX + 1, fromY + 2},
                {fromX + 1, fromY - 2},
                {fromX + 2, fromY - 1},
                {fromX + 2, fromY + 1},
                {fromX - 2, fromY - 1},
                {fromX - 2, fromY + 1}
        };

        for (int[] possible : allPossibilities
        ) {
            int x = possible[0];
            int y = possible[1];
            if (x < 8 && x > -1  && y < 8 && y > -1) {
                Piece toPiece = pieces.getPieces()[x][y];
                if (toPiece == null || toPiece.getIsWhite() != getIsWhite()) {

                    list.add(possible);
                }
            }
        }
        return list;
    }

    public String getClassName() {
        return "Knight";
    }
}
