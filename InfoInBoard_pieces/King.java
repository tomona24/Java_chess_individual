package InfoInBoard_pieces;

import java.util.ArrayList;

public class King extends Piece{

    public King( boolean isWhite) {
        super( isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♔";
        }
        return "♚";
    }
    @Override
    public ArrayList isValidMove(int fromX, int fromY) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{fromX - 1, fromY + 1});
        list.add(new int[]{fromX - 1, fromY});
        list.add(new int[]{fromX - 1, fromY - 1});
        list.add(new int[]{fromX + 1, fromY + 1});
        list.add(new int[]{fromX + 1, fromY});
        list.add(new int[]{fromX + 1, fromY - 1});
        list.add(new int[]{fromX, fromY - 1});
        list.add(new int[]{fromX, fromY + 1} );

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
