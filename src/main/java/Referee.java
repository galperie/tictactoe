import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class Referee {

    private Player playerOne;
    private Player playerTwo;

    public Referee(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        String[] placesForMoves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        Board board = new Board(printStream, placesForMoves);
        TWAwesomeBufferedReader bufferedReader = new TWAwesomeBufferedReader(new InputStreamReader(System.in));
        Player playerOne = new Player("Player 1", "X", board, bufferedReader, printStream);
        Player playerTwo = new Player("Player 2", "O", board, bufferedReader, printStream);
        Referee game = new Referee(playerOne, playerTwo);

        game.start(board);
    }

    public void start(Board board) {
        board.draw();
        playerOne.move();
        playerTwo.move();
    }

}
