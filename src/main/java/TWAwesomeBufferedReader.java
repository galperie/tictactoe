import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by egalperi on 6/18/15.
 */


public class TWAwesomeBufferedReader extends BufferedReader {

    public TWAwesomeBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() {
        try{
            return super.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}