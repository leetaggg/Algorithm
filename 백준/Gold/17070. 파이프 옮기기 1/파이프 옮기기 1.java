import java.io.*;
import java.util.*;

public class Main {

	static int result, n;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new boolean[n + 1][n + 1];

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					map[i][j] = true;
				}
			}
		}
		dfs(1, 2, 0);
		System.out.println(result);
	}

	static void dfs(int r, int c, int dir) {
		if (r == n && c == n) {
			result++;
			return;
		}

		if (dir == 0) {
			if (c < n && !map[r][c + 1]) {
				dfs(r, c + 1, 0);
			}
		} else if (dir == 1) {
			if (r < n && !map[r + 1][c]) {
				dfs(r + 1, c, 1);
			}
		} else if (dir == 2) {
			if (c < n && !map[r][c + 1]) {
				dfs(r, c + 1, 0);
			}

			if (r < n && !map[r + 1][c]) {
				dfs(r + 1, c, 1);
			}
		}

		if (r < n && c < n && !map[r + 1][c] && !map[r][c + 1] && !map[r + 1][c + 1]) {
			dfs(r + 1, c + 1, 2);
		}

	}
}