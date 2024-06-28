import java.io.*;
import java.util.*;

public class Main {

	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] map;
	static boolean[][] visited;
	static int cnt, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new boolean[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < line.length; j++) {
				if(line[j] == '1') {
					map[i][j] = true;
				}
			}
		}

		List<Integer> list = new ArrayList<>();

		int roomNum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
					roomNum++;
				}
			}
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();

		sb.append(roomNum).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;

		for (int[] dir : dirs) {
			int dr = r + dir[0];
			int dc = c + dir[1];
			if(0 <= dr && dr < n && 0 <= dc && dc < n && map[dr][dc] && !visited[dr][dc]) {
				dfs(dr, dc);
			}
		}
	}
}