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
    public ArrayList isValidMove(int fromX, int fromY) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{fromX - 1, fromY + 2});
        list.add(new int[]{fromX - 1, fromY - 2});
        list.add(new int[]{fromX + 1, fromY + 2});
        list.add(new int[]{fromX + 1, fromY - 2});
        list.add(new int[]{fromX + 2, fromY - 1});
        list.add(new int[]{fromX + 2, fromY + 1});
        list.add(new int[]{fromX - 2, fromY - 1});
        list.add(new int[]{fromX - 2, fromY + 1});
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
