import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int caseNumber = Integer.parseInt(st.nextToken());
			int[] heights = new int[20];
			for (int j = 0; j < 20; j++) {
				heights[j] = Integer.parseInt(st.nextToken());
			}

			int backwardSteps = func(heights);
			sb.append(caseNumber).append(" ").append(backwardSteps).append("\n");
		}

		System.out.print(sb);
	}

	private static int func(int[] heights) {
		int steps = 0;
		int[] line = new int[20];
		int lineLength = 0;

		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int position = lineLength;
			for (int j = 0; j < lineLength; j++) {
				if (line[j] > height) {
					position = j;
					break;
				}
			}

			steps += lineLength - position;

			for (int j = lineLength; j > position; j--) {
				line[j] = line[j - 1];
			}
			line[position] = height;
			lineLength++;
		}

		return steps;

	}
}
