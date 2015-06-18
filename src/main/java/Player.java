import java.io.BufferedReader;

/**
 * Created by egalperi on 6/18/15.
 */
public class Player {

    private TWAwesomeBufferedReader bufferedReader;

    public Player(TWAwesomeBufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public int move() {
        String move = bufferedReader.readLine();

        int moveAsInt = Integer.parseInt(move);

        return moveAsInt;
    }


}
