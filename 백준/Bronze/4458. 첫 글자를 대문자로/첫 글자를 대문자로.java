import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if (!line.isEmpty()) {
				String capitalizedLine = line.substring(0, 1).toUpperCase() + line.substring(1);
				System.out.println(capitalizedLine);
			}
		}
	}
}