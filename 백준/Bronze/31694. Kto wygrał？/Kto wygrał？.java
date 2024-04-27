import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] algosiaScores = new int[18];
		int[] bajtekScores = new int[18];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 18; i++) {
			algosiaScores[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 18; i++) {
			bajtekScores[i] = Integer.parseInt(st.nextToken());
		}

		String winner = determineWinner(algosiaScores, bajtekScores);
		System.out.println(winner);
	}

	private static String determineWinner(int[] algosiaScores, int[] bajtekScores) {
		int algosiaTotal = 0;
		int bajtekTotal = 0;

		for (int i = 0; i < 18; i++) {
			algosiaTotal += algosiaScores[i];
			bajtekTotal += bajtekScores[i];
		}

		if (algosiaTotal > bajtekTotal) {
			return "Algosia";
		} else if (bajtekTotal > algosiaTotal) {
			return "Bajtek";
		} else {
			for (int score = 10; score >= 0; score--) {
				int algosiaCount = countScore(algosiaScores, score);
				int bajtekCount = countScore(bajtekScores, score);

				if (algosiaCount > bajtekCount) {
					return "Algosia";
				} else if (bajtekCount > algosiaCount) {
					return "Bajtek";
				}
			}

			return "remis";
		}
	}

	private static int countScore(int[] scores, int score) {
		int count = 0;
		for (int i = 0; i < 18; i++) {
			if (scores[i] == score) {
				count++;
			}
		}
		return count;
	}
}