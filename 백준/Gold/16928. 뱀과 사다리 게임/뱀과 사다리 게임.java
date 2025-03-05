import java.io.*;
import java.util.*;

public class Main {

	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x] = y;
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		visited[1] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 1; i <= 6; i++) {
				int sum = i + cur.loc;
				if (sum <= 0 || sum > 100 || visited[sum]) continue;
				if (sum == 100) {
					return 	cur.cnt + 1;
				}

				int next = sum;

				if (map[sum] != 0) next = map[sum];

				visited[next] = true;
				q.add(new Node(next, cur.cnt + 1));
			}
		}

		return -1;
	}

	public static class Node {
		int loc;
		int cnt;

		public Node(int loc, int cnt) {
			this.loc = loc;
			this.cnt = cnt;
		}
	}
}