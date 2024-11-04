import java.io.*;
import java.util.*;

public class Main {

	static List<List<Node>> tree;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tree = new ArrayList<>(n + 1);

		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			tree.get(to).add(new Node(from, len));
			tree.get(from).add(new Node(to, len));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to =Integer.parseInt(st.nextToken());
			int from =Integer.parseInt(st.nextToken());

			sb.append(bfs(to, from)).append("\n");
		}

		System.out.println(sb);
	}

	static int bfs(int to, int from) {
		boolean[] visited = new boolean[n + 1];

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(to, 0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.idx == from) {
				return cur.length;
			}

			for (Node next : tree.get(cur.idx)) {
				if(!visited[next.idx]) {
					visited[next.idx] = true;
					q.offer(new Node(next.idx, cur.length + next.length));
				}
			}
		}

		return 0;
	}

	static class Node {
		int idx;
		int length;

		public Node(int idx, int length) {
			this.idx = idx;
			this.length = length;
		}
	}
}