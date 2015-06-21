import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/18/15.
 */
public class PlayerTest {

    private PrintStream printStream;
    private Board board;
    private PlayerInput playerInput;
    private String name;

    @Before
    public void setup() {
        playerInput = mock(PlayerInput.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        name = "Player 1";
    }

    @Test
    public void shouldMakeMoveOnBoardWhenMoving() {
        Player player = new Player("Player 1", "X", board, playerInput, printStream);
        when(playerInput.getPlayerMove(name)).thenReturn(3);

        player.move();

        verify(board).addMove(3, "X");
    }

}
