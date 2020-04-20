package InfoInBoard_input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static final String[] TYPES = {"help", "board", "resign", "moves"};

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        while (!invalidInput(userInput)) {
            System.out.println("Write to move");
            System.out.print(prompt);
            userInput = in.nextLine();
        }
        return userInput;
    }

    public static boolean invalidInput(String input) {
        if (checkString(input)) {
            return true;
        } else if (input.length() == 2 && checkSquare(input)) {
            return true;
        } else if (input.length() == 4 && checkMove(input)) {
            return true;
        }
        return false;
    }

    public static boolean checkString(String input) {
        for (String type : TYPES) {
            if (type.equals(input)) {
                return true;
            }
        }
        return false;
    }


    public static boolean checkSquare(String input) {
        char x = input.charAt(0);
        char y = input.charAt(1);
        if (checkAlpha(x) && checkNum(y)) {
            return true;
        }
        System.out.println("Invalid letter. Type 2 letters (e.g. b1)");
        return false;

    }

    public static boolean checkMove(String input) {
        char fromX = input.charAt(0);
        char fromY = input.charAt(1);
        char toX = input.charAt(2);
        char toY = input.charAt(3);
        if (checkAlpha(fromX) && checkAlpha(toX) && checkNum(fromY) && checkNum(toY)) {
            return true;
        } else {
            System.out.println("Invalid letter. Type number as the second & fourth letter (e.g. b1c3).");
            return false;
        }
    }

    private static boolean checkNum(Character c) {
        try {
            int num = Integer.parseInt(String.valueOf(c));
            if (num <= 8 && num > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkAlpha(Character c) {
        if ((int)Character.toUpperCase(c) >= 65 && (int)Character.toUpperCase(c) < 73) {
            return true;
        } else {
            return false;
        }
    }
}
