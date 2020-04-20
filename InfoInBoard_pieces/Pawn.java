package InfoInBoard_pieces;

import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean isPromoted;
    private Piece newPiece;

    public Pawn( boolean isWhite) {
        super(isWhite);
        this.isPromoted = false;
    }
//
//    //check for Pawn
//    public boolean checkPromo() {
//        if(position.getY() == 0 && getIsWhite() == false) {
//            return true;
//        } else if (position.getY() == 8 && getIsWhite() == true) {
//            return true;
//        }
//        return false;
//    }

//    public void canPromote() {
//        if(!isPromoted && checkPromo() ) {
//            this.isPromoted = true;
//        }
//    }

    public boolean getIsPromoted() { return isPromoted;}


    public Piece getNewPiece() { return newPiece; }

    public void setNewPiece(Piece newPiece){
        this.newPiece = newPiece;
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♙";
        }
        return "♟";
    }

    @Override
    public ArrayList isValidMove(int fromX, int fromY) {
        ArrayList<int[]> list = new ArrayList<>();
        if(getIsWhite()) {
            list.add(new int[]{fromX, fromY - 1});
            list.add(new int[]{fromX - 1, fromY - 1});
            list.add(new int[]{fromX + 1, fromY - 1});
            if(fromY == 1) {
                list.add(new int[]{fromX, fromY - 2});
            }
        } else {
            list.add(new int[]{fromX, fromY + 1});
            list.add(new int[]{fromX - 1, fromY + 1});
            list.add(new int[]{fromX + 1, fromY + 1});
            if(fromY == 6) {
                list.add(new int[]{fromX, fromY + 2});
            }
        }
        return list;
    }
//    @Override
//    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
//        if(!super.isValidMove(fromX, fromY, toX, toY)){
//            return false;
//        }
//        boolean pt1 = toY == fromY + 1 && toX == fromX;
//        return pt1;
//    }

}
