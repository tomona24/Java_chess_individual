package InfoInBoard_input;

import InfoInBoard_pieces.Position;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static final String[] TYPES = {"help", "board", "resign", "moves"};


    public static String getUserInput(String prompt) {
        System.out.println("Write to move");
        System.out.print(prompt);
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
            while (!invalidInput(userInput)) {
                userInput = in.nextLine();
            }
        return userInput;
    }

    public static boolean invalidInput(String input) {
        if(checkString(input)){
            return true;
        } else if (checkSquare(input)) {
            return true;
        } else if (checkMove(input)){
            return true;
        }
        return false;
    }

    public static boolean checkString(String input) {
        for (String type: TYPES) {
            if(type.equals(input)) {
                return true;
            }
        }
        return false;
    }


    public static boolean checkSquare(String input) {
        if(input.length() != 2) {
            System.out.println("Invalid letters. Type 2 letters");
            return false;
        }
        char x = input.charAt(0);
        char y = input.charAt(1);
        if(x < 65 && x >= 73 ) {
            System.out.println("Invalid letter. Type alphabet as the first letter.");
            return false;
        }
        try {
            Integer.parseInt(String.valueOf(y));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid letter. Type number as the second letter.");
            return false;
        }
    }

    public static boolean checkMove(String input) {
        if(input.length() != 4) {
            System.out.println("Invalid letters. Type 4 letters (e.g. b1c3)");
            return false;
        }
        char fromX = input.charAt(0);
        char fromY = input.charAt(1);
        char toX = input.charAt(3);
        char toY = input.charAt(4);
        if(fromX < 65 && fromX >= 73 && toX < 65 && toX >= 73) {
            System.out.println("Invalid letter. Type alphabet as the first & third letter (e.g. b1c3).");
            return false;
        }
        try {
            Integer.parseInt(String.valueOf(fromY));
            Integer.parseInt(String.valueOf(toY));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid letter. Type number as the second & fourth letter (e.g. b1c3).");
            return false;
        }
    }

}
