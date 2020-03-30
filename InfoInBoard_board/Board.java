package InfoInBoard_board;


import InfoInBoard_pieces.Piece;
import InfoInBoard_pieces.Pieces;

public class Board  {
    private String[][] board;
    private Pieces pieces;
 // constructor
    public Board() throws Exception {
        this.board = new String[8][8];
        this.pieces = new Pieces();
    }

    private void setPieces (Piece piece){
        board[piece.getX()-1][piece.getY()-1] = piece.getPiece();
    }

    public void initializeBoard() throws Exception {
        pieces.setPieces();
        for (int i = 0; i < pieces.getPieces().length; i++ ) {
            setPieces(pieces.getPieces()[i]);
        }
    }

    public void reloadBoard() {
        for (int i = 0; i < pieces.getPieces().length; i++ ) {
            setPieces(pieces.getPieces()[i]);
        }
    }


    public void showOnBoard() {
        int num = 8;
        System.out.println(boardTopEdge());
        for (int i = 0; i < 8; i++) {
            System.out.print(boardSideEdge());
            for (int k = 0; k < 8; k++) {
                if (board[k][i] != null) {
                    System.out.print(board[k][i]);
                } else {
                    if (k % 2 == 0) {
                        System.out.print("▒");
                    } else {
                        System.out.print("█");
                    }
                }
            }
            System.out.print(boardSideEdge());
            System.out.print(num--);
            System.out.println();
        }
        System.out.println(boardBottomEdge());
    }

    public static String boardTopEdge(){
        String s = "╔";
        for (int i = 0; i < 8; i++) {
            s += "=";
        }
        s += "╗";
        return s;
    }
    public static String boardSideEdge(){
        String s = "║";
        return s;
    }
    public static String boardBottomEdge(){
        String s = "╚";
        for (int i = 0; i < 8; i++) {
            s += "=";
        }
        s += "╝\n ";
        char ch = 65;
        for (int k = 0; k < 8; k ++) {
            s += ch++;
        }
        return s;
    }
}
