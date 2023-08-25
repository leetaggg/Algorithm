import java.io.*;
import java.util.*;

public class Main {
	static List<List<Node>> graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		graph = new ArrayList<List<Node>>();
		dist = new int[v + 1];
		for(int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Arrays.fill(dist, INF);
		dijkstra(k);
		for(int i = 1; i <= v; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodeIdx = node.idx;
			int nodeWeight = node.weight;
			for(Node next : graph.get(nodeIdx)) {
				if(dist[next.idx] > dist[nodeIdx] + next.weight) {
					dist[next.idx] = dist[nodeIdx] + next.weight;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}
	
	static class Node{
		int idx;
		int weight;
		
		Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
	}
}
