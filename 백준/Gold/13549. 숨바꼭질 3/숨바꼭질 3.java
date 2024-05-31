import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100_000;
	static boolean[] visited = new boolean[MAX + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(bfs(n, k));
	}

	public static int bfs(int n, int k) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.loc] = true;

			if (node.loc == k) {
				min = Math.min(min, node.time);
			}

			if (node.loc * 2 <= MAX && !visited[node.loc * 2]) {
				q.offer(new Node(node.loc * 2, node.time));
			}

			if (node.loc + 1 <= MAX && !visited[node.loc + 1]) {
				q.offer(new Node(node.loc + 1, node.time + 1));
			}

			if (node.loc - 1 >= 0 && !visited[node.loc - 1]) {
				q.offer(new Node(node.loc - 1, node.time + 1));
			}

		}
		return min;
	}

	static class Node {
		int loc;
		int time;

		Node(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}
	}
}