import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int score = 0;
		int consecutiveCorrect = 0;

		for (int i = 0; i < N; i++) {
			int result = Integer.parseInt(st.nextToken());
			if (result == 1) {
				consecutiveCorrect++;
				score += consecutiveCorrect;
			} else {
				consecutiveCorrect = 0;
			}
		}
		System.out.println(score);

		br.close();
	}
}