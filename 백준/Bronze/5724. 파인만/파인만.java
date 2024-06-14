import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			int N = Integer.parseInt(line.trim());
			if (N == 0)
				break;

			int totalSquares = 0;
			for (int i = 1; i <= N; i++) {
				totalSquares += i * i;
			}

			System.out.println(totalSquares);
		}
	}
}