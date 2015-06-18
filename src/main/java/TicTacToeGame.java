import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGame {

    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;

    public TicTacToeGame(PrintStream printStream, Player playerOne, Player playerTwo) {
        this.printStream = printStream;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        String[] placesForMoves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        Board board = new Board(printStream, placesForMoves);
        TWAwesomeBufferedReader bufferedReader = new TWAwesomeBufferedReader(new InputStreamReader(System.in));
        Player playerOne = new Player(bufferedReader);
        Player playerTwo = new Player(bufferedReader);
        TicTacToeGame game = new TicTacToeGame(printStream, playerOne, playerTwo);

        game.start(board);
    }

    public void start(Board board) {
        board.drawBoard();

        printStream.println("Player 1, What is your move (Pick 1-9)?");
        int currentMove = playerOne.move();
        board.addPlayerMove(currentMove, "Player1");

        printStream.println("Player 2, What is your move (Pick 1-9)?");
        currentMove = playerTwo.move();
        board.addPlayerMove(currentMove, "Player2");
    }

    public Player changeTurn() {
        Player activePlayer = playerOne;

        if(activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }

        return activePlayer;
    }
}
