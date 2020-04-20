import InfoInBoard_board.Board;
import InfoInBoard_input.Menu;
import InfoInBoard_input.Input;

import java.util.HashMap;


public class GameController {
    private static final String HELP = "help";
    private static final String BOARD = "board";
    private static final String RESIGN = "resign";
    private static final String MOVES = "moves";
    private static Board newBoard;

    public GameController() throws Exception {
        newBoard = new Board();

    }

//    private HashMap makeSet() {
//        HashMap<String, ?> menuCommand = new HashMap<>();
//        menuCommand.put(HELP, Menu.showHelp());
//    }

    public static void startGame() throws Exception {
        newBoard.initializeBoard();

        String input = Input.getUserInput("Enter UCI (type 'help' for help) : ");

        if (input.equals("help")) {

        } else if(input.length() == 4) {
            newBoard.movement(input);
        } else if (input.length() == 2) {
            newBoard.showPossibility(input);
        }
    }
}
