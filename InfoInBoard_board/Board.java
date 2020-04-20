package InfoInBoard_board;


import InfoInBoard_pieces.Piece;
import InfoInBoard_pieces.Pieces;

import java.util.ArrayList;

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
        int[] letters = makeLettersList(input);
        moveFromTo(letters);
        reloadBoard();
    }

    /**
     * For movement
     * @param input
     * @return
     */

    private int[] makeLettersList(String input){
        int[] letters = new int[input.length()];
        for(int i = 0; i < input.length(); i++) {
            if(i % 2 == 0) {
                letters[i] = (int)Character.toUpperCase(input.charAt(i)) - 64 - 1;
            } else {
                letters[i] = Integer.parseInt(String.valueOf(input.charAt(i))) - 1;
            }
        }
        return letters;
    }


    /**
     * check the move (2letters)
     * @return
     */
    public ArrayList<int[]> checkThePossibilities(int[] letters){
        int fromX = letters[1];
        int fromY = letters[2];
        Piece[][] pieces = this.pieces.getPieces();
        Piece piece = pieces[fromX][fromX];
        ArrayList<int[]> possibilities = piece.isValidMove(fromX, fromY);
        for(int i = 0; i < possibilities.size(); i++) {
            int[] position = (int[]) possibilities.get(i);
            Piece pieceTo = pieces[position[0]][position[1]];
            if(pieceTo != null && pieceTo.getIsWhite() == piece.getIsWhite()) {
                possibilities.remove(i);
            }
        }
        return possibilities;
    }



    // check the move (4letters)
    private void moveFromTo(int[] letters) {
        int fromX = letters[0];
        int fromY = letters[1];
        int toX = letters[2];
        int toY = letters[3];
        int[] to = new int[]{toX, toY};
        Piece[][] pieces = this.pieces.getPieces();
        ArrayList<int[]> possibilities = checkThePossibilities(letters);
        for (int[] position: possibilities
             ) {
            System.out.println(position[0] + position[1]);
        }
//        boolean canMove = false;
//        for (Object position: possibilities
//             ) {
//            if(position.equals(to)){
//                canMove = true;
//                break;
//            }
//        }
//        if(canMove) {
            pieces[toX][toY] = pieces[fromX][fromY];
            pieces[fromX][fromY] = null;
        }
//    }

}
