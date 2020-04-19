package InfoInBoard_pieces;


public class Pieces{
    private Piece[] pieces;

    public Pieces() throws Exception {
        this.pieces = new Piece[32];
    }

    public void setPieces() throws Exception {
        pieces[0] = new Pawn(new Position(1, 2),true);
        pieces[1] = new Pawn(new Position(2, 2),true);
        pieces[2] = new Pawn(new Position(3, 2),true);
        pieces[3] = new Pawn(new Position(4, 2),true);
        pieces[4] = new Pawn(new Position(5, 2),true);
        pieces[5] = new Pawn(new Position(6, 2),true);
        pieces[6] = new Pawn(new Position(7, 2),true);
        pieces[7] = new Pawn(new Position(8, 2),true);
        pieces[8] = new Rook(new Position(1, 1),true);
        pieces[9] = new Knight(new Position(2, 1),true);
        pieces[10] = new Bishop(new Position(3, 1),true);
        pieces[11] = new Queen(new Position(4, 1),true);
        pieces[12] = new King(new Position(5, 1),true);
        pieces[13] = new Bishop(new Position(6, 1),true);
        pieces[14] = new Knight(new Position(7, 1),true);
        pieces[15] = new Rook(new Position(8, 1),true);
        pieces[16] = new Pawn(new Position(1, 7),false);
        pieces[17] = new Pawn(new Position(2, 7),false);
        pieces[18] = new Pawn(new Position(3, 7),false);
        pieces[19] = new Pawn(new Position(4, 7),false);
        pieces[20] = new Pawn(new Position(5, 7),false);
        pieces[21] = new Pawn(new Position(6, 7),false);
        pieces[22] = new Pawn(new Position(7, 7),false);
        pieces[23] = new Pawn(new Position(8, 7),false);
        pieces[24] = new Rook(new Position(1, 8),false);
        pieces[25] = new Knight(new Position(2, 8),false);
        pieces[26] = new Bishop(new Position(3, 8),false);
        pieces[27] = new King(new Position(4, 8),false);
        pieces[28] = new Queen(new Position(5, 8),false);
        pieces[29] = new Bishop(new Position(6, 8),false);
        pieces[30] = new Knight(new Position(7, 8),false);
        pieces[31] = new Rook(new Position(8, 8),false);
    }

    public Piece[] getPieces() {
        return pieces;
    }
}
