import InfoInBoard_board.Board;
import InfoInBoard_input.Input;

public class GameController {
    private final String HELP = "help";
    private final String BOARD = "board";
    private final String RESIGN = "resign";
    private Board newBoard;
    private boolean isContinue;
    private Input input;

    public GameController() throws Exception {
        newBoard = new Board();
        this.input = new Input();
        isContinue = true;
    }

    public void startGame() throws Exception {
        newBoard.initializeBoard();
        while (isContinue) {
            declareTurn();
            String in = input.getUserInput("Enter UCI (type 'help' for help) : ");
            makeSet(in);
            if(newBoard.getKilledKing()) {
                isContinue = false;
                judgeWinner();
            }
        }
    }

    private void makeSet(String input) {
        switch (input) {
            case HELP:
                showHelp();
                break;
            case BOARD:
                newBoard.reloadBoard();
                break;
            case RESIGN:
                isContinue = false;
                judgeWinner();
                break;
            default:
                if (input.length() == 2) {
                    newBoard.showPossibility(input);
                } else if (input.length() == 4) {
                    newBoard.movement(input);
                }
        }
    }

    private void showHelp() {
        String help = "* type 'help' for help";
        String board = "* type 'board' to see the board again";
        String resign = "* type 'resign' to resign";
        String square = "* type a square (e.g. b1, e2) to list possible moves for that square";
        String UCI = "* type UCI (e.g. b1c3, e7e8) to make a move";
        System.out.println(help);
        System.out.println(board);
        System.out.println(resign);
        System.out.println(square);
        System.out.println(UCI);
    }

    private void judgeWinner() {
        if (newBoard.getTurnIsWhite()) {
            System.out.println("Black is winner.");
        } else {
            System.out.println("White is winner.");
        }
    }

    private void declareTurn() {
        if (newBoard.getTurnIsWhite()) {
            System.out.println("White to move");
        } else {
            System.out.println("Black to move");
        }
    }

}
