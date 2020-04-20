package InfoInBoard_pieces;


public class Pieces {
    private Piece[][] pieces;

    public Pieces() throws Exception {
        this.pieces = new Piece[8][8];
    }

    public void setPieces() throws Exception {
        pieces[0][1] = new Pawn(true);
        pieces[1][1] = new Pawn(true);
        pieces[2][1] = new Pawn(true);
        pieces[3][1] = new Pawn(true);
        pieces[4][1] = new Pawn(true);
        pieces[5][1] = new Pawn(true);
        pieces[6][1] = new Pawn(true);
        pieces[7][1] = new Pawn(true);
        pieces[0][0] = new Rook(true);
        pieces[1][0] = new Knight(true);
        pieces[2][0] = new Bishop(true);
        pieces[3][0] = new Queen(true);
        pieces[4][0] = new King(true);
        pieces[5][0] = new Bishop(true);
        pieces[6][0] = new Knight(true);
        pieces[7][0] = new Rook(true);

        pieces[0][6] = new Pawn(false);
        pieces[1][6] = new Pawn(false);
        pieces[2][6] = new Pawn(false);
        pieces[3][6] = new Pawn(false);
        pieces[4][6] = new Pawn(false);
        pieces[5][6] = new Pawn(false);
        pieces[6][6] = new Pawn(false);
        pieces[7][6] = new Pawn(false);
        pieces[0][7] = new Rook(false);
        pieces[1][7] = new Knight(false);
        pieces[2][7] = new Bishop(false);
        pieces[3][7] = new King(false);
        pieces[4][7] = new Queen(false);
        pieces[5][7] = new Bishop(false);
        pieces[6][7] = new Knight(false);
        pieces[7][7] = new Rook(false);


        pieces[2][5] = new Pawn(false);
    }


    public Piece[][] getPieces() {
        return pieces;
    }

}
