package InfoInBoard_pieces;

public class Rook extends Piece{
    private Position position;

    public Rook(Position position, boolean isWhite) {
        super(position, isWhite);
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


    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♖";
        }
        return "♜";
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
