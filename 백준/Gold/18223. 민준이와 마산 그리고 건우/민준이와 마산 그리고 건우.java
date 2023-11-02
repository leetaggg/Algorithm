import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] graph;
    static int v;
    public static void main(String[] args) throws IOException {

        v = read();
        int e = read();
        int p = read();

        graph = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int from = read();
            int to = read();
            int weight = read();

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        int[] dist = dijkstra(1);
        int startToGoal = dist[v];
        int toGunwoo = dist[p];
        int gunwooToGoal = dijkstra(p)[v];

        System.out.println(startToGoal >= toGunwoo + gunwooToGoal ? "SAVE HIM" : "GOOD BYE");
    }

    static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[v + 1];
        Arrays.fill(dist, 20000);
        dist[start] = 0;

        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.idx] < now.weight) continue;
            for (Node next : graph[now.idx]) {
                if(dist[now.idx] + next.weight < dist[next.idx]){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }

    static class Node{
        int idx;
        int weight;

        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}