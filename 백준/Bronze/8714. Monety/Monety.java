import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int countHeads = 0;
		int countTails = 0;

		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(tokenizer.nextToken());
			if (coin == 0) {
				countHeads++;
			} else {
				countTails++;
			}
		}

		System.out.println(Math.min(countHeads, countTails));
	}
}
