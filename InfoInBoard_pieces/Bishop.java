package InfoInBoard_pieces;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♗";
        }
        return "♝";
    }

    @Override
    public ArrayList isValidMove(int fromX, int fromY) {
        ArrayList<int[]> list = new ArrayList<>();
        int kariX = fromX;
        int kariY = fromY;

        while(kariX < 8 || kariY < 8) {
            list.add(new int[]{++kariX, ++kariY});
        }
        kariX = fromX;
        kariY = fromY;
        while(kariX < 8 || kariY > -1) {
            list.add(new int[]{++ kariX, --kariY});
        }
        kariX = fromX;
        kariY = fromY;
        while(kariX > -1 || kariY < 8) {
            list.add(new int[]{--kariX, ++kariY});
        }
        kariX = fromX;
        kariY = fromY;
        while(kariX > -1 || kariY > -1) {
            list.add(new int[]{--kariX, --kariY});
        }
        return list;
    }


//
//    @Override
//    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
//        if (!super.isValidMove(fromX, fromY, toX, toY)) {
//            return false;
//        }
//        boolean from = fromX % 2 == 0 && fromY == 0;
//        boolean to = toX % 2 == 0 && toY == 0;
//        return (from && to) || (!from && !to);
//    }
}
