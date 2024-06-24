import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int player1Wins = 0;
			int player2Wins = 0;

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char p1 = st.nextToken().charAt(0);
				char p2 = st.nextToken().charAt(0);

				if ((p1 == 'R' && p2 == 'S') || (p1 == 'S' && p2 == 'P') || (p1 == 'P' && p2 == 'R')) {
					player1Wins++;
				} else if ((p2 == 'R' && p1 == 'S') || (p2 == 'S' && p1 == 'P') || (p2 == 'P' && p1 == 'R')) {
					player2Wins++;
				}
			}

			if (player1Wins > player2Wins) {
				System.out.println("Player 1");
			} else if (player2Wins > player1Wins) {
				System.out.println("Player 2");
			} else {
				System.out.println("TIE");
			}
		}
	}
}