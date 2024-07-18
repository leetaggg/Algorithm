import java.io.*;
import java.util.*;

public class Main {

	static List<List<Node>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>(n + 1);

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(to).add(new Node(from, weight));
			graph.get(from).add(new Node(to, weight));
		}

		System.out.println(dijkstra(n));
	}

	static int dijkstra(int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new Node(1, 0));
		dist[1] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if (node.idx == n) break;
			if (node.weight > dist[node.idx]) continue;
			for (Node next : graph.get(node.idx)) {
				int nextWeight = dist[node.idx] + next.weight;
				if (dist[next.idx] > nextWeight) {
					dist[next.idx] = nextWeight;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}

		}

		return dist[n];
	}

	static class Node {
		int idx;
		int weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
}
