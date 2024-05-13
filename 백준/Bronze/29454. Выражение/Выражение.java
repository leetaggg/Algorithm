import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			sum += cards[i];
		}

		for (int i = 0; i < n; i++) {
			if (sum - cards[i] == cards[i]) {
				System.out.println(i + 1);
				return;
			}
		}
	}
}