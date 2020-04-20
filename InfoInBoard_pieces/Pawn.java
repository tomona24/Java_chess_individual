package InfoInBoard_pieces;

import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean isPromoted;
    private Piece newPiece;

    public Pawn(boolean isWhite) {
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

    public boolean getIsPromoted() {
        return isPromoted;
    }


    public Piece getNewPiece() {
        return newPiece;
    }

    public void setNewPiece(Piece newPiece) {
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
    public ArrayList possibleMovement(int fromX, int fromY, Pieces pieces) {
        ArrayList<int[]> possibilities = new ArrayList<>();
        if (getIsWhite()) {
            if(fromX > 0 && pieces.getPieces()[fromX - 1][fromY + 1] != null && !pieces.getPieces()[fromX][fromY + 1].getIsWhite()) {
                    possibilities.add(new int[]{fromX - 1, fromY + 1});
            }else if(fromX < 7 && pieces.getPieces()[fromX + 1][fromY + 1] != null && !pieces.getPieces()[fromX][fromY + 1].getIsWhite()) {
                    possibilities.add(new int[]{fromX + 1, fromY + 1});
            } else if(pieces.getPieces()[fromX][fromY + 1] == null){
                possibilities.add(new int[]{fromX, fromY + 1});
                if (fromY == 1 && pieces.getPieces()[fromX][fromY + 2] == null) {
                    possibilities.add(new int[]{fromX, fromY + 2});
                }
            }
        } else {
            // x = 2, x = 6
            if(fromX > 0 && pieces.getPieces()[fromX - 1][fromY - 1] != null && pieces.getPieces()[fromX][fromY - 1].getIsWhite()) {
                    possibilities.add(new int[]{fromX - 1, fromY - 1});
            } else if (fromX < 7 && pieces.getPieces()[fromX + 1][fromY - 1] != null && pieces.getPieces()[fromX][fromY - 1].getIsWhite()) {
                    possibilities.add(new int[]{fromX + 1, fromY - 1});
            } else if(pieces.getPieces()[fromX][fromY - 1] == null){
                possibilities.add(new int[]{fromX, fromY - 1});
                if (fromY == 6 && pieces.getPieces()[fromX][fromY - 2] == null) {
                    possibilities.add(new int[]{fromX, fromY - 2});
                }
            }
        }
        return possibilities;
    }

}
