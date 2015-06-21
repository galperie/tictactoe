import java.io.PrintStream;


/**
 * Created by egalperi on 6/21/15.
 */
public class PlayerInput {

    private TWAwesomeBufferedReader bufferedReader;
    private Board board;
    private PrintStream printStream;
    private String desiredMoveString;

    public PlayerInput(TWAwesomeBufferedReader bufferedReader, Board board, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.board = board;
        this.printStream = printStream;
    }

    public int getPlayerMove(String name) {
        int desiredMoveInt = askPlayer(name);

        while(!board.isValidMove(desiredMoveInt)) {
            printStream.println("Location already taken. Try Again: ");
            desiredMoveInt = askPlayer(name);
        }
        return desiredMoveInt;
    }

    public int askPlayer(String name) {
        printStream.println(name + ", What is your move (Pick 1-9)?");
        String desiredMoveString = bufferedReader.readLine();
        return Integer.parseInt(desiredMoveString);
    }


}
