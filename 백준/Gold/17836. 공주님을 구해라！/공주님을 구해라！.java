import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int n, m, t;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}

	public static void bfs() {
		Queue<Hero> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		q.offer(new Hero(0, 0, 0));
		visited[0][0] = true;

		int swordTime = Integer.MAX_VALUE;
		int nonSwordTime = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Hero hero = q.poll();

			if(hero.time > t) break;

			if(hero.r == n - 1 && hero.c == m - 1) {
				nonSwordTime = hero.time;
				break;
			}

			for (int[] dir : dirs) {
				int dr = hero.r + dir[0];
				int dc = hero.c + dir[1];

				if(0 <= dr && dr < n && 0 <= dc && dc < m && map[dr][dc] != 1 && !visited[dr][dc]) {
					visited[dr][dc] = true;

					if (map[dr][dc] == 2) {
						swordTime = hero.time + n + m - dr - dc - 1;
						continue;
					}
					q.offer(new Hero(dr, dc, hero.time + 1));
				}
			}
		}

		if(swordTime > t && nonSwordTime > t) {
			System.out.println("Fail");
		} else {
			System.out.println(Math.min(swordTime, nonSwordTime));
		}
	}

	public static class Hero {
		int r;
		int c;
		int time;

		public Hero(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}