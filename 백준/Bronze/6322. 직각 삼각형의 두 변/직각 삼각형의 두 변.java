import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int testCase = 1;

		while ((line = br.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			System.out.println("Triangle #" + testCase);

			boolean isPossible = true;
			double result = 0;

			if (c == -1) {
				result = Math.sqrt(a * a + b * b);
				if (result <= 0 || result > 10000) {
					isPossible = false;
				}
			} else if (a == -1) {
				if (c * c - b * b <= 0) {
					isPossible = false;
				} else {
					result = Math.sqrt(c * c - b * b);
				}
			} else if (b == -1) {
				if (c * c - a * a <= 0) {
					isPossible = false;
				} else {
					result = Math.sqrt(c * c - a * a);
				}
			}

			if (isPossible && result > 0) {
				if (c == -1) {
					System.out.printf("c = %.3f\n", result);
				} else if (a == -1) {
					System.out.printf("a = %.3f\n", result);
				} else if (b == -1) {
					System.out.printf("b = %.3f\n", result);
				}
			} else {
				System.out.println("Impossible.");
			}

			System.out.println();
			testCase++;
		}
	}
}