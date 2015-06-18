import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
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
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);
    }

    @Test
    public void shouldPrintBlankBoardWhenFirstDrawn() {
        board.drawBoard();

        verify(printStream, times(3)).println(" | | ");
        verify(printStream, times(2)).println("-----");
    }

    @Test
    public void shouldAddXToBoardAtPositionWhenPlayerOnePicksThatSpot() {
        int move = 2;
        board.addPlayerMove(move, "Player1");

        assertEquals(allPositions[move - 1], "X");
    }

    @Test
    public void shouldDrawUpdatedBoardWhenPlayerHasMadeAMove() {
        board.addPlayerMove(2, "Player1");

        verify(printStream).println(" |X| ");
        verify(printStream, times(2)).println(" | | ");
        verify(printStream, times(2)).println("-----");
    }

    @Test
    public void shouldAddOToBoardAtPositionWhenPlayer2PicksThatSpot() {
        int move = 2;
        board.addPlayerMove(move, "Player2");

        assertEquals(allPositions[move-1], "O");
    }

    @Test
    public void shouldPrintErrorMessageWhenPlayerTwoChoosesTakenPosition() {
        board.addPlayerMove(2, "Player1");
        board.addPlayerMove(2, "Player2");

        verify(printStream).println("Location already taken");
    }
}
