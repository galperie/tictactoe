
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGameTest {

    @Test
    public void shouldDrawBoardWhenMainStarts() {
        Board board = mock(Board.class);
        TicTacToeGame game = new TicTacToeGame();

        game.start(board);

        verify(board).drawBoard();
    }
}
