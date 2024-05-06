import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] schedule = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				schedule[i][j] = line.charAt(j);
			}
		}

		int escapeTime = -1;

		for (int i = 0; i < M; i++) {
			boolean canEscape = true;
			for (int j = 0; j < N; j++) {
				if (schedule[j][i] == 'O') {
					canEscape = false;
					break;
				}
			}
			if (canEscape) {
				escapeTime = i + 1;
				break;
			}
		}

		if (escapeTime == -1) {
			System.out.println("ESCAPE FAILED");
		} else {
			System.out.println(escapeTime);
		}
	}
}