
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/18/15.
 */
public class RefereeTest {

    private Board board;
    private Referee referee;
    private Player currentPlayer;
    private Player playerOne;
    private Player playerTwo;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        currentPlayer = mock(Player.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        printStream = mock(PrintStream.class);
        referee = new Referee(playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        referee.start(board);

        verify(board).draw();
    }

    @Test
    public void shouldAskPlayerOneForMoveWhenGameStarts() {
        referee.start(board);

        verify(playerOne).move();
    }

    @Test
    public void shouldAskPlayerTwoForMoveWhenTheirTurn() {
        referee.start(board);

        verify(playerTwo).move();
    }


}
