
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/18/15.
 */
public class TicTacToeGameTest {

    @Test
    public void shouldDrawBoardWhenMainStarts() {
        Board board = new Board();
        TicTacToeGame game = new TicTacToeGame();

        game.start();

        verify(board).drawBoard();
    }
}
