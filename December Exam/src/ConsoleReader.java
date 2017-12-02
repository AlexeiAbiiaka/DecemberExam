import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleReader extends BufferedReader {

	public ConsoleReader(InputStream in) {
		super(new InputStreamReader(in));
	}
	public ConsoleReader(InputStreamReader in) {
		super(in);
	}

	@Override
	public String readLine() {
		try {
			return super.readLine();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
