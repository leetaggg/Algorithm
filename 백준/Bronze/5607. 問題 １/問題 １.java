import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int scoreA = 0;
		int scoreB = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cardA = Integer.parseInt(st.nextToken());
			int cardB = Integer.parseInt(st.nextToken());

			if (cardA > cardB) {
				scoreA += cardA + cardB;
			} else if (cardA < cardB) {
				scoreB += cardA + cardB;
			} else {
				scoreA += cardA;
				scoreB += cardB;
			}
		}
		System.out.println(scoreA + " " + scoreB);
	}
}