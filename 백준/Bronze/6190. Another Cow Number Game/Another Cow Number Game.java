import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		int score = 0;

		while (N != 1) {
			if (N % 2 == 0) {
				N /= 2;
			} else {
				N = 3 * N + 1;
			}
			score++;
		}

		System.out.println(score);
	}
}