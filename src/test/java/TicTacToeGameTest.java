
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGameTest {

    private Board board;
    private TicTacToeGame game;
    private Player playerOne;
    private Player playerTwo;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        printStream = mock(PrintStream.class);
        game = new TicTacToeGame(printStream, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        game.start(board);

        verify(board).drawBoard();
    }

    @Test
    public void shouldAskPlayer1ForMoveWhenGameStarts() {
        game.start(board);

        verify(printStream).println("Player 1, What is your move (Pick 1-9)?");
    }

    @Test
    public void shouldGetPlayerChosenMoveWhenGameStarts() {
        game.start(board);

        verify(playerOne).move();
    }

    @Test
    public void shouldMakePlayer1MoveWhenGameStarts() {
        when(playerOne.move()).thenReturn(1);

        game.start(board);

        verify(board).addPlayerMove(1, "Player1");
    }

    @Test
    public void shouldAskPlayer2ForMoveAfterPlayer1WhenGameStarts() {
        game.start(board);

        verify(printStream).println("Player 1, What is your move (Pick 1-9)?");
        verify(printStream).println("Player 2, What is your move (Pick 1-9)?");
    }

    @Test
    public void shouldMakePlayer2MoveAfterPlayer1WhenPlayer1Moves() {
        when(playerOne.move()).thenReturn(1);

        game.start(board);

        Player currentPlayer = game.changeTurn();

        assertEquals(playerTwo, currentPlayer);
    }




}
