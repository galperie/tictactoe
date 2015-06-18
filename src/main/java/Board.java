import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class Board {

    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void drawBoard() {
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
    }
}
