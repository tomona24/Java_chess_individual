package InfoInBoard_input;

import InfoInBoard_board.Board;

public class Menu {

    public static void showHelp() {
        String help = "* type 'help' for help";
        String board = "* type 'board' to see the board again";
        String resign = "* type 'resign' to resign";
        String moves = "* type 'moves' to list all possible moves";
        String square = "* type a square (e.g. b1, e2) to list possible moves for that square";
        String UCI = "* type UCI (e.g. b1c3, e7e8) to make a move";
        System.out.println(help);
        System.out.println(board);
        System.out.println(resign);
        System.out.println(moves);
        System.out.println(square);
        System.out.println(UCI);
    }

}
