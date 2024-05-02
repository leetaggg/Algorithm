import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] grid = new String[10][10];

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				grid[i][j] = st.nextToken();
			}
		}

		for (int i = 0; i < 10; i++) {
			boolean same = true;
			for (int j = 1; j < 10; j++) {
				if (!grid[i][j].equals(grid[i][0])) {
					same = false;
					break;
				}
			}
			if (same) {
				System.out.println(1);
				return;
			}
		}

		for (int j = 0; j < 10; j++) {
			boolean same = true;
			for (int i = 1; i < 10; i++) {
				if (!grid[i][j].equals(grid[0][j])) {
					same = false;
					break;
				}
			}
			if (same) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
	}
}