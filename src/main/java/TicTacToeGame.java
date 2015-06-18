import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGame {

    private PrintStream printStream;

    public TicTacToeGame(PrintStream printStream) {

        this.printStream = printStream;
    }

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        TicTacToeGame game = new TicTacToeGame(printStream);
        String[] placesForMoves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        Board board = new Board(printStream, placesForMoves);
        TWAwesomeBufferedReader bufferedReader = new TWAwesomeBufferedReader(new InputStreamReader(System.in));
        PlayerInput playerInput = new PlayerInput(bufferedReader);

        game.start(board, playerInput);
    }

    public void start(Board board, PlayerInput playerInput) {
        board.drawBoard();
        printStream.println("Player 1, What is your move (Pick 1-9)?");
        int currentMove = playerInput.getPlayerMove();
        board.addPlayerMove(currentMove, "Player1");

        printStream.println("Player 2, What is your move (Pick 1-9)?");
        currentMove = playerInput.getPlayerMove();
        board.addPlayerMove(currentMove, "Player2");
    }
}
