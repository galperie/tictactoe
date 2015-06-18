import java.io.BufferedReader;

/**
 * Created by egalperi on 6/18/15.
 */
public class PlayerInput {

    private TWAwesomeBufferedReader bufferedReader;

    public PlayerInput(TWAwesomeBufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public int getPlayerMove() {
        String move = bufferedReader.readLine();

        int moveAsInt = Integer.parseInt(move);

        return moveAsInt;
    }


}
