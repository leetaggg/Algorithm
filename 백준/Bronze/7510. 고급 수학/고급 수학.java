import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());

			int max = Math.max(a, Math.max(b, c));
			int side1, side2;

			if (max == a) {
				side1 = b;
				side2 = c;
			} else if (max == b) {
				side1 = a;
				side2 = c;
			} else {
				side1 = a;
				side2 = b;
			}

			System.out.println("Scenario #" + i + ":");
			if (max * max == side1 * side1 + side2 * side2) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			System.out.println();
		}
	}
}