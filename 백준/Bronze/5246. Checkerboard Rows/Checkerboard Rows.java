import java.util.*;

public class Main {
	private static int solve(int[] positions_x, int[] positions_y) {
		int result = 0;

		int[] rowCounts = new int[8];

		for (int i = 0; i < positions_y.length; i++) {
			int row = positions_y[i];
			rowCounts[row - 1]++;
		}

		for (int count : rowCounts) {
			if (count > result) {
				result = count;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numCases = sc.nextInt();

		for (int i = 0; i < numCases; i++) {
			int numPieces = sc.nextInt();

			int[] positions_x = new int[numPieces];
			int[] positions_y = new int[numPieces];

			for (int j = 0; j < numPieces; j++) {
				positions_x[j] = sc.nextInt();
				positions_y[j] = sc.nextInt();
			}

			System.out.println(solve(positions_x, positions_y));
		}
	}
}