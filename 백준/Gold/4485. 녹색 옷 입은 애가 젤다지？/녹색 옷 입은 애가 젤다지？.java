import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] dist, map;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCase = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0) break;

			map = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], INF);
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dijkstra();

			sb.append("Problem ").append(testCase++).append(": ").append(dist[n - 1][n - 1]).append('\n');
		}

		System.out.println(sb);
	}

	static void dijkstra() {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		pq.offer(new Node(0, 0, map[0][0]));
		dist[0][0] = map[0][0];
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (node.r == n -1 && node.c == n - 1) break;
			if (node.weight > dist[node.r][node.c]) continue;

			for (int[] dir : dirs) {
				int dr = node.r + dir[0];
				int dc = node.c + dir[1];
				if (dr < 0 || dr >= n || dc < 0 || dc >= n)
					continue;

				int nextWeight = node.weight + map[dr][dc];

				if (dist[dr][dc] > nextWeight) {
					dist[dr][dc] = nextWeight;
					pq.offer(new Node(dr, dc, dist[dr][dc]));
				}
			}


		}
	}

	static class Node {
		int r;
		int c;
		int weight;

		public Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
	}
}
