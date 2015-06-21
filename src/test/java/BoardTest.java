import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
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

        board.draw();

        verify(printStream).println(" | | \n" +
                                    "---------\n" +
                                    " | | \n" +
                                    "---------\n" +
                                    " | | \n");
    }

    @Test
    public void shouldAddMarkerToBoardWhenMoving() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        board.addMove(3, "X");

        assertEquals(allPositions[2], "X");
    }

    @Test
    public void shouldDrawUpdatedBoardWhenAddingMove() {
        allPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        board.addMove(2, "X");

        verify(printStream).println(" |X| \n" +
                "---------\n" +
                " | | \n" +
                "---------\n" +
                " | | \n");
    }

    @Test
    public void shouldCheckPositionIsTakenWhenAddingMoveToTakenPosition() {
        allPositions = new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        assertThat(board.isTaken(1), is(true));
    }

    @Test
    public void shouldCheckPositionIsNotTakenWhenAddingMoveToNotTakenPosition() {
        allPositions = new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "};
        board = new Board(printStream, allPositions);

        assertThat(board.isTaken(2), is(false));
    }

}
