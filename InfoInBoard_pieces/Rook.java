package InfoInBoard_pieces;

import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(boolean isWhite) {
        super( isWhite);
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♖";
        }
        return "♜";
    }

    @Override
    public ArrayList isValidMove(int fromX, int fromY) {
        ArrayList<int[]> list = new ArrayList<>();
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
//        return sameX || sameY;
//    }

}
