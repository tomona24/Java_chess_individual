package InfoInBoard_board;


import InfoInBoard_input.Movement;
import InfoInBoard_pieces.Piece;
import InfoInBoard_pieces.Pieces;

import java.util.List;

public class Board {
    private Pieces pieces;
    private Movement movement;
    private boolean turnIsWhite;
    private boolean killedKing;

    // constructor
    public Board() throws Exception {
        this.pieces = new Pieces();
        movement = new Movement();
        turnIsWhite = true;
        killedKing = false;
    }

    public void initializeBoard() throws Exception {
        pieces.setPieces();
        reloadBoard();
    }

    public boolean getTurnIsWhite(){
        return turnIsWhite;
    }

    public boolean getKilledKing() {
        return killedKing;
    }


    public void reloadBoard()  {
        showOnBoard(pieces.getPieces());
    }

    private void showOnBoard(Piece[][] pieces) {
        int num = 1;
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
        int[] letters = movement.makeLettersList(input);
        if(hasPiece(letters[0], letters[1], pieces.getPieces())) {
            moveFromTo(letters, pieces.getPieces());
        } else {
            System.out.println("You can't select!");
        }
        reloadBoard();
    }

    /**
     * check the move (2letters)
     * @return
     */
    private List<int[]> checkThePossibilities(int fromX, int fromY, Piece[][] pieces){
        Piece piece = pieces[fromX][fromY];
        List<int[]> possibilities = piece.possibleMovement(fromX, fromY, this.pieces);
        return possibilities;
    }



    private void moveFromTo(int[] letters, Piece[][] pieces) {
        int fromX = letters[0];
        int fromY = letters[1];
        int toX = letters[2];
        int toY = letters[3];
        List<int[]> possibilities = checkThePossibilities(fromX, fromY, pieces);
        boolean canMove = false;
        for (int[] position: possibilities) {
            if(position[0] == toX && position[1] == toY){
                canMove = true;
                break;
            }
        }
        if(canMove) {
            if(pieces[toX][toY] != null && pieces[toX][toY].getClass().toString().equals("class InfoInBoard_pieces.King")){
                killedKing = true;
            }
            pieces[toX][toY] = pieces[fromX][fromY];
            pieces[fromX][fromY] = null;
            turnIsWhite = !turnIsWhite;
        }
    }

    public void showPossibility(String input) {
        int[] letters = movement.makeLettersList(input);
        if(hasPiece(letters[0], letters[1], pieces.getPieces())) {
            List<int[]> possibilities = checkThePossibilities(letters[0], letters[1], pieces.getPieces());
            for (int[] possible : possibilities) {
                System.out.println(movement.convertIntToPosition(possible));
            }
        } else {
            System.out.println("You can't select!");
        }
    }

    private boolean hasPiece(int fromX, int fromY, Piece[][] pieces){
        Piece piece = pieces[fromX][fromY];
        if(piece != null && piece.getIsWhite() == turnIsWhite) {
            return true;
        } else {
            return false;
        }
    }
}
