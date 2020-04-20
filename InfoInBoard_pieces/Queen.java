package InfoInBoard_pieces;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(boolean isWhite) {
        super( isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♕";
        }
        return "♛";
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
        for (int i = 0; i < 8; i++) {
            if (i != fromY) {
                list.add(new int[]{fromX, i});
            }
            if (i != fromX) {
                list.add(new int[]{i, fromY});
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
//        boolean sameX = fromX == toX;
//        boolean sameY = fromY == toY;
//        boolean from = fromX % 2 == 0 && fromY == 0;
//        boolean to = toX % 2 == 0 && toY == 0;
//
//        return (from && to) || (!from && !to) || sameX || sameY;
//    }


}
