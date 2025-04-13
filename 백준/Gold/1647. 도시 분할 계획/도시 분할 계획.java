import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Node> graph = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.add(new Node(to, from, weight));
		}

		graph.sort((o1, o2) -> o1.weight - o2.weight);

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int answer = 0;
		int max = 0;

		for (int i = 0; i < graph.size(); i++) {
			Node node = graph.get(i);

			if (find(node.to) != find(node.from)) {
				answer += node.weight;
				union(node.to, node.from);

				max = node.weight;
			}
		}

		System.out.println(answer - max);
	}

	static class Node {
		int to;
		int from;
		int weight;

		Node(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return false;
		} else {
			parent[x] = y;
			return true;
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}