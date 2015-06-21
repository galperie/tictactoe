import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/21/15.
 */
public class PlayerInputTest {

    private PlayerInput playerInput;
    private TWAwesomeBufferedReader bufferedReader;
    private Board board;
    private PrintStream printStream;
    private String name;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(TWAwesomeBufferedReader.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerInput = new PlayerInput(bufferedReader, board, printStream);
        name = "Player 1";
    }

    @Test
    public void shouldAskPlayerForMoveWhenGettingMove() {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isValidMove(1)).thenReturn(true);

        playerInput.getPlayerMove(name);

        verify(printStream).println(contains("What is your move (Pick 1-9)?"));
    }

    @Test
    public void shouldGetPlayerInput() {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isValidMove(1)).thenReturn(true);

        assertThat(playerInput.getPlayerMove(name), is(1));
    }

    @Test
    public void shouldCheckIfLocationTakenWhenPlayerInputsALocationNotValid() {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isValidMove(1)).thenReturn(true);

        playerInput.getPlayerMove(name);

        verify(board).isValidMove(1);
    }

    @Test
    public void shouldPromptPlayerToPickAMoveAgainWhenLocationChosenIsNotValid() {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        when(board.isValidMove(1)).thenReturn(false);
        when(board.isValidMove(2)).thenReturn(true);

        playerInput.getPlayerMove(name);

        verify(bufferedReader, times(2)).readLine();
    }

    @Test
    public void shouldKeepPromptingPlayerToPickAMoveUntilLocationIsValidWhenLocationChosenIsNotValid() {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("1").thenReturn("2");
        when(board.isValidMove(1)).thenReturn(false);
        when(board.isValidMove(2)).thenReturn(true);

        playerInput.getPlayerMove(name);

        verify(bufferedReader, times(4)).readLine();
    }

    @Test
    public void shouldTellPlayerThatLocationSelectedIsAlreadyTakenWhenTheyPickMove() {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        when(board.isValidMove(1)).thenReturn(false);
        when(board.isValidMove(2)).thenReturn(true);

        playerInput.getPlayerMove(name);

        verify(printStream).println("Location already taken. Try Again: ");
    }

}