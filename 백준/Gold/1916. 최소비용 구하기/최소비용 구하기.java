import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> graph;
    static int n, m;
    static int[] dist;
    static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(n + 1);
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start, int end){
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int idx = node.idx;
            int weight = node.weight;

            if(dist[idx] < weight) continue;

            for (Node next : graph.get(idx)) {
                if(dist[next.idx] > dist[idx] + next.weight){
                    dist[next.idx] = dist[idx] + next.weight;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }

    static class Node{
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}