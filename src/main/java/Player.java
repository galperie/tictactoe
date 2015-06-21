import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class Player {

    private String name;
    private String marker;
    private PrintStream printStream;
    private Board board;
    private PlayerInput playerInput;

    public Player(String name, String marker, Board board, PlayerInput playerInput, PrintStream printStream) {
        this.name = name;
        this.board = board;
        this.playerInput = playerInput;
        this.marker = marker;
        this.printStream = printStream;
    }

    public void move() {
        int desiredMove = playerInput.getPlayerMove(name);

        board.addMove(desiredMove, marker);
    }
}
