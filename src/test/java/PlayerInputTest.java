import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by egalperi on 6/18/15.
 */
public class PlayerInputTest {

    @Test
    public void shouldGetMoveFromPlayerWhenItIsTheirTurn() {
        TWAwesomeBufferedReader bufferedReader = mock(TWAwesomeBufferedReader.class);
        PlayerInput playerInput = new PlayerInput(bufferedReader);

        when(bufferedReader.readLine()).thenReturn("1");

        int move = playerInput.getPlayerMove();

        assertEquals(move, 1);
    }
}
