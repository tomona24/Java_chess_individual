package InfoInBoard_pieces;

import java.util.ArrayList;

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♔";
        }
        return "♚";
    }


    @Override
    public ArrayList possibleMovement(int fromX, int fromY, Pieces pieces) {
        ArrayList<int[]> list = new ArrayList<>();
        int[][] allPossibilities = new int[][]{
                {fromX - 1, fromY + 1},
                {fromX - 1, fromY},
                {fromX - 1, fromY - 1},
                {fromX + 1, fromY + 1},
                {fromX + 1, fromY},
                {fromX + 1, fromY - 1},
                {fromX, fromY - 1},
                {fromX, fromY + 1}
        };

        for (int[] possible : allPossibilities
        ) {
            int x = possible[0];
            int y = possible[1];
            if (x < 8 && x > -1 && y < 8 && y > -1) {
                Piece toPiece = pieces.getPieces()[x][y];
                if (toPiece == null || toPiece.getIsWhite() != getIsWhite()) {
                    list.add(possible);
                }
            }
        }
        return list;
    }

//
//    @Override
//    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
//        if(!super.isValidMove(fromX, fromY, toX, toY)){
//            return false;
//        }
//        boolean x = (fromX - 1 <= toX)  && (toX <= fromX + 1);
//        boolean y = (fromY - 1 <= toY) && (toY <= fromY + 1);
//        return x && y;
//    }

}
