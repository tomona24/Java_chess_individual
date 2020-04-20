import InfoInBoard_board.Board;
import InfoInBoard_input.Menu;
import InfoInBoard_input.Input;


public class GameController {
    public static void startGame() throws Exception {
        Board newBoard = new Board();
        newBoard.initializeBoard();

        String input = Input.getUserInput("Enter UCI (type 'help' for help) : ");
        if(input == "help") {
            Menu.showHelp();
        }
        if(input.length() == 4) {
            newBoard.movement(input);
        }
    }
}
