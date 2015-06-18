import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by egalperi on 6/18/15.
 */
public class Board {

    private PrintStream printStream;
    private String[] placesForMoves;

    public Board(PrintStream printStream, String[] placesForMoves) {
        this.printStream = printStream;
        this.placesForMoves = placesForMoves;
    }

    public void drawBoard() {
        printStream.println(placesForMoves[0] + "|" + placesForMoves[1] + "|" + placesForMoves[2]);
        printStream.println("-----");
        printStream.println(placesForMoves[3] + "|" + placesForMoves[4] + "|" + placesForMoves[5]);
        printStream.println("-----");
        printStream.println(placesForMoves[6] + "|" + placesForMoves[7] + "|" + placesForMoves[8]);
    }

    public void addPlayerMove(int move, String player) {
        if(placesForMoves[move-1].equals(" ")) {
            if(player.equals("Player1")) {
                placesForMoves[move-1] = "X";
            }
            if(player.equals("Player2")) {
                placesForMoves[move-1] = "O";
            }
            drawBoard();
        } else {
            printStream.println("Location already taken");
        }
    }

}
