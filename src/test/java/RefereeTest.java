
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/18/15.
 */
public class RefereeTest {

    private Board board;
    private Referee referee;
    private Player playerOne;
    private Player playerTwo;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        printStream = mock(PrintStream.class);
        referee = new Referee(playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        when(board.isFull()).thenReturn(true);

        referee.start(board, printStream);

        verify(board).draw();
    }

    @Test
    public void shouldAskPlayerOneForMoveWhenGameStarts() {
        when(board.isFull()).thenReturn(false).thenReturn(true);

        referee.start(board, printStream);

        verify(playerOne).move();
    }

    @Test
    public void shouldAskPlayerTwoForMoveWhenTheirTurn() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);

        referee.start(board, printStream);

        verify(playerTwo).move();
    }

    @Test
    public void shouldMakePlayerTwoCurrentPlayerWhenItIsPlayerTwosTurn() {
        Player currentPlayer = referee.switchCurrentPlayer();

        assertThat(currentPlayer, is(playerTwo));
    }

    @Test
    public void shouldMakeCurrentPlayerGoWhenItIsTheirTurn() {
        referee.currentPlayerTakeTurn();

        verify(playerOne).move();
    }

    @Test
    public void shouldMakePlayerTwoTakeTurnAfterPlayerOneWhenItIsTheirTurn() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);

        referee.start(board, printStream);

        verify(playerOne).move();
        verify(playerTwo).move();
    }

    @Test
    public void shouldNotTakeTurnIfBoardIsFullWhenGameStarting() {
        when(board.isFull()).thenReturn(true);

        referee.start(board, printStream);

        verify(playerOne, never()).move();
        verify(playerTwo, never()).move();
    }

    @Test
    public void shouldSayTheGameIsADrawWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);

        referee.start(board, printStream);

        verify(printStream).println(contains("Game is a draw"));
    }



}
