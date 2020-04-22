package InfoInBoard_board;

import InfoInBoard_pieces.*;

import java.util.HashMap;
import java.util.Scanner;


public class Promotion {

    public Promotion() {}

    public boolean canPromotion(Piece piece, int y) {
        return reachEdge(piece, y);
    }

    private boolean reachEdge(Piece piece, int y) {
        if(piece.getClassName().equals("Pawn")) {
            if (piece.getIsWhite() && y == 7) {
                return true;
            } else return !piece.getIsWhite() && y == 0;
        }
        return false;
    }

    public Piece promotion(Piece piece) {
        int num = getUserInput();
        return chosenPiece(piece.getIsWhite(), num);
    }


    private int getUserInput() {
        System.out.print("You can promote this pawn!");
        options();
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();
        while (!invalidInput(userInput)) {
            System.out.println("Write a number");
            options();
            userInput = in.nextInt();
        }
        return userInput;
    }

    private boolean invalidInput(int num) {
        if (num > 0 && num < 5) {
            return true;
        }
        return false;
    }

    private void options() {
        System.out.println("Which piece do you want promote it to?\n" +
                "1.Queen\n" +
                "2.Bishop\n" +
                "3.Knight\n" +
                "4.Rook" +
                "Type the number:\n");
    }

    private Piece chosenPiece(boolean isWhite, int num) {
        switch (num) {
            case 1:
                return new Queen(isWhite);
            case 2:
                return new Bishop(isWhite);
            case 3:
                return new Knight(isWhite);
            case 4:
                return new Rook(isWhite);
            default:
                return null;
        }
    }
}
