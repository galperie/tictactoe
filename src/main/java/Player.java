import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class Player {

    private String name;
    private TWAwesomeBufferedReader bufferedReader;
    private String marker;
    private PrintStream printStream;
    private Board board;

    public Player(String name, String marker, Board board, TWAwesomeBufferedReader bufferedReader, PrintStream printStream) {
        this.name = name;
        this.board = board;
        this.bufferedReader = bufferedReader;
        this.marker = marker;
        this.printStream = printStream;
    }

    public int getDesiredMove() {
        printStream.println(name + ", What is your move (Pick 1-9)?");

        String move = bufferedReader.readLine();

        int moveAsInt = Integer.parseInt(move);

        return moveAsInt;
    }

    public void move() {
        int desiredMove = getDesiredMove();

        if(board.isTaken(desiredMove)) {
            printStream.println("Location already taken, try again: ");
        }

        board.addMove(desiredMove, marker);
    }
}
