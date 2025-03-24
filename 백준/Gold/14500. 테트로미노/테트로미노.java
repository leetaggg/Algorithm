import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int max = 0;
	static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] fyDirs = new int[][]{{}, {}, {}, {}};
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][k];
		visited = new boolean[n][k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				fuckYou(i, j);
			}
		}

		System.out.println(max);
	}

	public static void dfs(int r, int c, int depth, int value) {

		if (depth == 4) {
			max = Math.max(max, value);
			return;
		}

		for (int[] dir : dirs) {
			int x = r + dir[0];
			int y = c + dir[1];

			if (0 <= x && x < n && 0 <= y && y < k && !visited[x][y]) {
				visited[x][y] = true;
				dfs(x, y, depth + 1, value + map[x][y]);
				visited[x][y] = false;
			}
		}
	}

	public static void fuckYou(int r, int c) {
		int[][][] shapes = {
			{{0, 0}, {-1, 0}, {0, -1}, {0, 1}}, // ㅗ
			{{0, 0}, {1, 0}, {0, -1}, {0, 1}},  // ㅜ
			{{0, 0}, {-1, 0}, {1, 0}, {0, 1}},  // ㅏ
			{{0, 0}, {-1, 0}, {1, 0}, {0, -1}}  // ㅓ
		};

		for (int[][] shape : shapes) {
			boolean isValid = true;
			int sum = 0;

			for (int[] s : shape) {
				int x = r + s[0];
				int y = c + s[1];

				if (x < 0 || x >= n || y < 0 || y >= k) {
					isValid = false;
					break;
				}
				sum += map[x][y];
			}

			if (isValid) {
				max = Math.max(max, sum);
			}
		}
	}
}