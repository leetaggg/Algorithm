import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] cards = new int[n];
		boolean[] isPrime = new boolean[1_000_001];
		int max = 0;

		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, cards[i]);
			isPrime[cards[i]] = true;
		}

		int[] arr = new int[max + 1];

		for (int i = 1; i <= max; i++) {
			if (!isPrime[i]) continue;

			for (int j = i * 2; j <= max; j += i) {
				if (isPrime[j]) {
					arr[i]++;
					arr[j]--;
				}
			}
		}


		StringBuilder sb = new StringBuilder();
		for (int i : cards) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb);
	}
}