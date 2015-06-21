import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class Referee {

    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    public Referee(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        currentPlayer = playerOne;
    }

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        String[] placesForMoves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        Board board = new Board(printStream, placesForMoves);
        TWAwesomeBufferedReader bufferedReader = new TWAwesomeBufferedReader(new InputStreamReader(System.in));
        PlayerInput playerInput = new PlayerInput(bufferedReader, board, printStream);
        Player playerOne = new Player("Player 1", "X", board, playerInput, printStream);
        Player playerTwo = new Player("Player 2", "O", board, playerInput, printStream);
        Referee game = new Referee(playerOne, playerTwo);

        game.start(board, printStream);
    }

    public void start(Board board, PrintStream printStream) {
        board.draw();

        while(!board.isFull()) {
            currentPlayerTakeTurn();
            switchCurrentPlayer();
        }

        printStream.println("Game is a draw");

    }

    public Player switchCurrentPlayer() {
        if(currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
        return currentPlayer;
    }

    public void currentPlayerTakeTurn() {
        currentPlayer.move();
    }
}
