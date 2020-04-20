package InfoInBoard_pieces;

import java.util.ArrayList;

public class Knight extends Piece{


    public Knight(  boolean isWhite) {
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
    public ArrayList possibleMovement(int fromX, int fromY, Pieces pieces) {
        ArrayList<int[]> list = new ArrayList<>();
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

        for (int[] possible: allPossibilities
        ) {
            int x = possible[0];
            int y = possible[1];
            Piece toPiece = pieces.getPieces()[x][y];
            if(toPiece == null || toPiece.getIsWhite() != getIsWhite() && !(x == 8 || x == -1 || y == 8 || y == -1)) {
                list.add(possible);
            }
        }
        return list;
    }

//    @Override
//    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
//        if(!super.isValidMove(fromX, fromY, toX, toY)){
//            return false;
//        }
//        boolean pt1 = (toX == fromX - 1 || toX == fromX + 1) && (toY == fromY + 2 || toY == fromY -2);
//        boolean pt2 = (toX == fromX - 2 || toX == fromX + 2) && (toY == fromY + 1 || toY == fromY -1);
//        return pt1 || pt2;
//    }

}
