import InfoInBoard_board.Board;
import InfoInBoard_input.Menu;
import InfoInBoard_input.Input;

import static InfoInBoard_input.Menu.*;

public class GameController {
    private static final String HELP = "help";
    private static final String BOARD = "board";
    private static final String RESIGN = "resign";
    private static final String MOVES = "moves";


    public static void startGame() throws Exception {
        Board newBoard = new Board();
        newBoard.initializeBoard();
        newBoard.showOnBoard();

        String input = Input.getUserInput("Enter UCI (type 'help' for help) : ");
        showHelp();
//        switch (input) {
//            case HELP:
//                showHelp();
//                break;
//            case BOARD:
//                newBoard.showOnBoard();
//                break;
//            case RESIGN:
//                showResign();
//                return;
//            case MOVES:
//                showMoves();
//                break;
//        }
    }
}
