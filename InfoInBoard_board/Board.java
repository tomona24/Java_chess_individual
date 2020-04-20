package InfoInBoard_board;


import InfoInBoard_input.Movement;
import InfoInBoard_pieces.Piece;
import InfoInBoard_pieces.Pieces;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Pieces pieces;

    // constructor
    public Board() throws Exception {
        this.pieces = new Pieces();
    }

    public void initializeBoard() throws Exception {
        pieces.setPieces();
        reloadBoard();
    }

    public void reloadBoard()  {
        showOnBoard(pieces);
    }

    private void showOnBoard(Pieces arr) {
        int num = 1;
        Piece[][] pieces = arr.getPieces();
        System.out.println(boardTopEdge());
        for (int i = 0; i < 8; i++) {
            System.out.print(boardSideEdge());
            for (int k = 0; k < 8; k++) {
                if (pieces[k][i] != null) {
                    System.out.print(pieces[k][i].getPiece());
                } else {
                    if (k % 2 == 0) {
                        System.out.print("▒");
                    } else {
                        System.out.print("█");
                    }
                }
            }
            System.out.print(boardSideEdge());
            System.out.print(num++);
            System.out.println();
        }
        System.out.println(boardBottomEdge());
    }

    private static String boardTopEdge() {
        String s = "╔";
        for (int i = 0; i < 8; i++) {
            s += "=";
        }
        s += "╗";
        return s;
    }

    private static String boardSideEdge() {
        String s = "║";
        return s;
    }

    private static String boardBottomEdge() {
        String s = "╚";
        for (int i = 0; i < 8; i++) {
            s += "=";
        }
        s += "╝\n ";
        char ch = 65;
        for (int k = 0; k < 8; k++) {
            s += ch++;
        }
        return s;
    }



    public void movement(String input) {
        int[] letters = Movement.makeLettersList(input);
        moveFromTo(letters);
        reloadBoard();
    }

    /**
     * For movement
     * @param input
     * @return
     */




    /**
     * check the move (2letters)
     * @return
     */
    public List<int[]> checkThePossibilities(int fromX, int fromY){
        Piece[][] pieces = this.pieces.getPieces();
        Piece piece = pieces[fromX][fromY];
        System.out.println("white:" + piece.getIsWhite() + piece.getPiece() + " x:" + fromX + " y:" + fromY);
        List<int[]> possibilities = piece.possibleMovement(fromX, fromY, this.pieces);
        return possibilities;
    }


    // check the move (4letters)
    private void moveFromTo(int[] letters) {
        int fromX = letters[0];
        int fromY = letters[1];
        int toX = letters[2];
        int toY = letters[3];
        Piece[][] pieces = this.pieces.getPieces();
        List<int[]> possibilities = checkThePossibilities(fromX, fromY);
        boolean canMove = false;
        for (int[] position: possibilities
             ) {
            if(position[0] == toX && position[1] == toY){
                canMove = true;
                break;
            }
        }
        if(canMove) {
            pieces[toX][toY] = pieces[fromX][fromY];
            pieces[fromX][fromY] = null;
        }
    }

    public void showPossibility(String input) {
        int[] letters = Movement.makeLettersList(input);
        List<int[]> possibilities = checkThePossibilities(letters[0], letters[1]);
        for (int[] possible: possibilities
             ) {
            System.out.println(Movement.convertIntToPosition(possible));
        }
    }
}
