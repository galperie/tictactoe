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
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);

    }

    @Test
    public void shouldPrintBlankBoardWhenFirstDrawn() {
        board.drawBoard();

        verify(printStream, times(3)).println(" | | ");
        verify(printStream, times(2)).println("-----");
    }

    @Test
    public void shouldAddXToBoardAtPositionTwoWhenPlayerOnePicksThatSpot() {
        board.addPlayerMove(2, 1);


    }
}
