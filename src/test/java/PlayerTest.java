import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/18/15.
 */
public class PlayerTest {

    private TWAwesomeBufferedReader bufferedReader;
    private PrintStream printStream;
    private Board board;

    @Before
    public void setup() {
        bufferedReader = mock(TWAwesomeBufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
    }

    @Test
    public void shouldRecordWherePlayerWantsToMoveWhenMoving() {
        Player player = new Player("Player 1", "X", board, bufferedReader, printStream);

        when(bufferedReader.readLine()).thenReturn("1");

        int move = player.getDesiredMove();

        assertEquals(move, 1);
    }

    @Test
    public void shouldAskPlayerWhereTheyWantToMoveWhenMoving() {
        Player player = new Player("Player 1", "X", board, bufferedReader, printStream);
        when(bufferedReader.readLine()).thenReturn("1");

        player.move();

        verify(printStream).println("Player 1, What is your move (Pick 1-9)?");
    }

    @Test
    public void shouldMakeMoveOnBoardWhenMoving() {
        Player player = new Player("Player 1", "X", board, bufferedReader, printStream);
        when(bufferedReader.readLine()).thenReturn("3");

        player.move();

        verify(board).addMove(3, "X");
    }

    @Test
    public void shouldMakeMoveAgainWhenMovingToPositionAlreadyTaken() {
        Player player = new Player("Player 1", "X", board, bufferedReader, printStream);
        when(bufferedReader.readLine()).thenReturn("3").thenReturn("3");

        player.move();

        verify(printStream).println(contains("Try Again:"));
    }


}
