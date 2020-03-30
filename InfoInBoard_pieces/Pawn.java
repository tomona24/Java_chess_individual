package InfoInBoard_pieces;

public class Pawn extends Piece{
    private boolean isPromoted;
    private Piece newPiece;
    private Position position;

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
        this.isPromoted = false;
    }

    //check for Pawn
    public boolean checkPromo() {
        if(position.getY() == 0 && getIsWhite() == false) {
            return true;
        } else if (position.getY() == 8 && getIsWhite() == true) {
            return true;
        }
        return false;
    }

    public void canPromote() {
        if(!isPromoted && checkPromo() ) {
            this.isPromoted = true;
        }
    }

    public boolean getIsPromoted() { return isPromoted;}


    public Piece getNewPiece() { return newPiece; }

    public void setNewPiece(Piece newPiece){
        this.newPiece = newPiece;
    }

    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♙";
        }
        return "♟";
    }

//    @Override
//    public boolean isValidMove(Position newPosition) {
//        if(!super.isValidMove(position)) {
//            return false;
//        }
//        if (this.proceeding == 1) {
//            if (newPosition.getRow() == getPosition().getRow() + 1
//                    && newPosition.getCol() == getPosition().getCol() + 1) {
//                return true;
//            } else if (newPosition.getRow() == getPosition().getRow()
//                    && newPosition.getCol() == getPosition().getCol() + 2) {
//                return true;
//            }
//        } else {
//            if (newPosition.getRow() == getPosition().getRow() + 1
//                    && newPosition.getCol() == getPosition().getCol() + 1) {
//                return true;
//            }
//        }
//         return false;
//    }
}
