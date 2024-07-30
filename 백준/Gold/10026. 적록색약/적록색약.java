import java.io.*;
import java.util.*;

public class Main {

	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[][] nonRgb, rgb;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		nonRgb = new boolean[n][n];
		rgb = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int cntNonRgb = 0, cntRgb = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!nonRgb[i][j]) {
					dfs1(i, j, map[i][j]);
					cntNonRgb++;
				}

				if (!rgb[i][j]) {
					dfs2(i, j, map[i][j]);
					cntRgb++;
				}
			}
		}

		System.out.println(cntRgb + " " + cntNonRgb);
	}

	static void dfs1(int r, int c, char color) {
		nonRgb[r][c] = true;

		for (int[] dir : dirs) {
			int nr = r + dir[0];
			int nc = c + dir[1];
			if (0 <= nr && nr < n && 0 <= nc && nc < n && !nonRgb[nr][nc]) {
				if (color == 'R' || color == 'G') {
					if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
						dfs1(nr, nc, map[nr][nc]);
					}
				} else {
					if (color == map[nr][nc]) {
						dfs1(nr, nc, map[nr][nc]);
					}
				}
			}
		}
	}

	static void dfs2(int r, int c, char color) {
		rgb[r][c] = true;

		for (int[] dir : dirs) {
			int nr = r + dir[0];
			int nc = c + dir[1];
			if (0 <= nr && nr < n && 0 <= nc && nc < n && !rgb[nr][nc] && color == map[nr][nc]) {
 				dfs2(nr, nc, map[nr][nc]);
			}
		}
	}
}
