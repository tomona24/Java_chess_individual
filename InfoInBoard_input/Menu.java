package InfoInBoard_input;

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


//
//    public static void showResign() {
//        System.out.println("Game over - XXXX won by resignation");
//    }
//
//    public static void showMoves() {
//        System.out.println("This piece can move to ....");
//    }


}
