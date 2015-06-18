import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/18/15.
 */
public class BoardTest {

    @Test
    public void shouldPrintBlankBoardWhenFirstDrawn() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.drawBoard();

        verify(printStream, times(3)).println(" | | ");
        verify(printStream, times(2)).println("-----");
    }
}
