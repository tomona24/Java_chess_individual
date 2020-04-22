package InfoInBoard_board;

import InfoInBoard_input.Movement;
import InfoInBoard_pieces.Pawn;
import InfoInBoard_pieces.Piece;

import java.util.HashSet;
import java.util.List;

public class Board {
    private Pieces pieces;
    private Movement movement;
    private boolean turnIsWhite;
    private boolean killedKing;
    private Promotion promotion;

    // constructor
    public Board() throws Exception {
        this.pieces = new Pieces();
        movement = new Movement();
        turnIsWhite = true;
        killedKing = false;
        promotion = new Promotion();
    }

    public void initializeBoard() throws Exception {
        pieces.setPieces();
        reloadBoard();
    }

    public boolean getTurnIsWhite() {
        return turnIsWhite;
    }

    public boolean getKilledKing() {
        return killedKing;
    }


    public void reloadBoard() {
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
        if (hasPiece(letters[0], letters[1], pieces.getPieces())) {
            moveFromTo(letters, pieces.getPieces());
        } else {
            System.out.println("You can't select!");
        }
        reloadBoard();
    }

    /**
     * check the move (2letters)
     *
     * @return
     */
    private HashSet checkThePossibilities(int fromX, int fromY, Piece[][] pieces) {
        Piece piece = pieces[fromX][fromY];
        return piece.possibleMovement(fromX, fromY, this.pieces);
    }


    private void moveFromTo(int[] letters, Piece[][] pieces) {
        int fromX = letters[0];
        int fromY = letters[1];
        int toX = letters[2];
        int toY = letters[3];
        HashSet<int[]> possibilities = checkThePossibilities(fromX, fromY, pieces);
        boolean canMove = false;
        for (int[] position : possibilities) {
            if (position[0] == toX && position[1] == toY) {
                canMove = true;
                break;
            }
        }
        if (canMove) {
            if (pieces[toX][toY] != null && pieces[toX][toY].getClassName().equals("King")) {
                killedKing = true;
            }
            if (promotion.canPromotion(pieces[fromX][fromY], toY)) {
                pieces[toX][toY] = promotion.promotion(pieces[fromX][fromY]);
            } else {
                pieces[toX][toY] = pieces[fromX][fromY];
            }
            if (pieces[fromX][fromY].getClassName().equals("Pawn")) {
                if (toX == fromX - 1 && ((Pawn) pieces[fromX][fromY]).checkRightTheEnPassant(fromX, fromY, this.pieces)) {
                    pieces[fromX - 1][fromY] = null;
                } else if (toX == fromX + 1 && ((Pawn) pieces[fromX][fromY]).checkLeftTHeEnPassant(fromX, fromY, this.pieces)) {
                    pieces[fromX + 1][fromY] = null;
                }
            }
            pieces[fromX][fromY] = null;
            turnIsWhite = !turnIsWhite;
        }
    }

    public void showPossibility(String input) {
        int[] letters = movement.makeLettersList(input);
        if (hasPiece(letters[0], letters[1], pieces.getPieces())) {
            HashSet<int[]> possibilities = checkThePossibilities(letters[0], letters[1], pieces.getPieces());
            for (int[] possible : possibilities) {
                System.out.println(movement.convertIntToPosition(possible));
            }
        } else {
            System.out.println("You can't select!");
        }
    }

    private boolean hasPiece(int fromX, int fromY, Piece[][] pieces) {
        Piece piece = pieces[fromX][fromY];
        if (piece != null && piece.getIsWhite() == turnIsWhite) {
            return true;
        } else {
            return false;
        }
    }

}
