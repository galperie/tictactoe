
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGameTest {

    private Board board;
    private TicTacToeGame game;
    private PlayerInput playerInput;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerInput = mock(PlayerInput.class);
        printStream = mock(PrintStream.class);
        game = new TicTacToeGame(printStream);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        game.start(board, playerInput);

        verify(board).drawBoard();
    }

    @Test
    public void shouldAskPlayer1ForMoveWhenGameStarts() {
        game.start(board, playerInput);

        verify(printStream).println("Player 1, What is your move (Pick 1-9)?");
    }

    @Test
    public void shouldGetPlayerChosenMoveWhenGameStarts() {
        game.start(board, playerInput);

        verify(playerInput).getPlayerMove();
    }

    @Test
    public void shouldMakePlayer1MoveWhenGameStarts() {
        when(playerInput.getPlayerMove()).thenReturn(1);

        game.start(board, playerInput);

        verify(board).addPlayerMove(1, "Player1");
    }

}
