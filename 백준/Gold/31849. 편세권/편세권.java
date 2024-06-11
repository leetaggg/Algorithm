import java.io.*;
import java.util.*;

public class Main {

	static int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][m + 1];
		boolean[][] visited = new boolean[n + 1][m + 1];
		int minValue = Integer.MAX_VALUE;

		Queue<Convenience> q = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			int roomR = Integer.parseInt(st.nextToken());
			int roomC = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			map[roomR][roomC] = price;
		}

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			
			int convR = Integer.parseInt(st.nextToken());
			int convC = Integer.parseInt(st.nextToken());

			q.offer(new Convenience(convR, convC, convR, convC));
			visited[convR][convC] = true;
		}

		while (!q.isEmpty()) {
			Convenience conv = q.poll();

			for (int[] dir : dirs) {
				int dr = conv.dr + dir[0];
				int dc = conv.dc + dir[1];
				if(0 < dr && dr <= n && 0 < dc && dc <= m) {
					if(visited[dr][dc]) {
						continue;
					}
					if(map[dr][dc] > 0){
						int score = (Math.abs(dr - conv.r) + Math.abs(dc - conv.c)) * map[dr][dc];
						minValue = Math.min(minValue, score);
					}
					visited[dr][dc] = true;
					q.offer(new Convenience(conv.r, conv.c, dr, dc));
				}
			}
		}

		System.out.println(minValue);
	}

	static class Convenience {
		int r;
		int c;
		int dr;
		int dc;

		public Convenience(int r, int c, int dr, int dc) {
			this.r = r;
			this.c = c;
			this.dr = dr;
			this.dc = dc;
		}
	}
}