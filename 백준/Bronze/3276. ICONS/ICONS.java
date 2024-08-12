import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int minSum = Integer.MAX_VALUE;
		int bestRows = 1;
		int bestCols = N;

		for (int rows = 1; rows <= N; rows++) {
			int cols = (int) Math.ceil((double) N / rows);
			int currentSum = rows + cols;

			if (currentSum < minSum) {
				minSum = currentSum;
				bestRows = rows;
				bestCols = cols;
			}
		}

		System.out.println(bestRows + " " + bestCols);
	}
}