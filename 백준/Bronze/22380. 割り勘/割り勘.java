import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());

			if (N == 0 && M == 0) {
				break;
			}

			int[] A = new int[N];
			line = br.readLine();
			tokenizer = new StringTokenizer(line);

			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(tokenizer.nextToken());
			}

			int requiredAmountPerPerson = M / N;
			int collectedAmount = 0;

			for (int i = 0; i < N; i++) {
				if (A[i] >= requiredAmountPerPerson) {
					collectedAmount += requiredAmountPerPerson;
				} else {
					collectedAmount += A[i];
				}
			}

			System.out.println(collectedAmount);
		}
	}
}