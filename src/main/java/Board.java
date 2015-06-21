import java.io.PrintStream;

/**
 * Created by egalperi on 6/18/15.
 */
public class Board {

    private PrintStream printStream;
    private String[] cells;

    public Board(PrintStream printStream, String[] cells) {
        this.printStream = printStream;
        this.cells = cells;
    }

    public void draw() {
        printStream.println(
                cells[0] + "|" + cells[1] + "|" + cells[2] + "\n"
                + "---------" + "\n"
                + cells[3] + "|" + cells[4] + "|" + cells[5] + "\n"
                + "---------" + "\n"
                + cells[6] + "|" + cells[7] + "|" + cells[8] + "\n");
    }

    public void addMove(int move, String marker) {
            cells[move-1] = marker;
            draw();
    }

    public boolean isTaken(int position) {
        return !cells[position-1].equals(" ");
    }
}
