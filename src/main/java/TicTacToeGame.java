import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGame {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        PrintStream printStream = System.out;
        Board board = new Board(printStream);
        game.start(board);
    }

    public void start(Board board) {
        board.drawBoard();
    }
}
