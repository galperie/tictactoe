import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/18/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private String[] allPositions;
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintBlankBoardWhenFirstDrawn() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        board.drawBoard();

        verify(printStream, times(3)).println(" | | ");
        verify(printStream, times(2)).println("-----");
    }

    @Test
    public void shouldAddXToBoardAtPositionWhenPlayerOnePicksThatSpot() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);
        int move = 2;

        board.addPlayerMove(move, "Player1");

        assertEquals(allPositions[move - 1], "X");
    }

    @Test
    public void shouldDrawUpdatedBoardWhenPlayerHasMadeAMove() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        board.addPlayerMove(2, "Player1");

        verify(printStream).println(" |X| ");
        verify(printStream, times(2)).println(" | | ");
        verify(printStream, times(2)).println("-----");
    }

    @Test
    public void shouldAddOToBoardAtPositionWhenPlayer2PicksThatSpot() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);
        int move = 2;

        board.addPlayerMove(move, "Player2");

        assertEquals(allPositions[move-1], "O");
    }

    @Test
    public void shouldPrintErrorMessageWhenPlayerTwoChoosesTakenPosition() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        board.addPlayerMove(2, "Player1");
        board.addPlayerMove(2, "Player2");

        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldPrintDrawWhenBoardIsFull() {
        allPositions = new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X"};
        board = new Board(printStream, allPositions);

        board.addPlayerMove(9, "Player1");

        verify(printStream).println(contains("Game is a draw"));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        allPositions = new String[]{"X", "X", "X", "X", "X", "X", "X", "X", ""};
        board = new Board(printStream, allPositions);

        board.addPlayerMove(9, "Player1");

        assertEquals(board.isBoardFull(), true);
    }
}
