import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int n, m, x, y;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        dijkstra(y);
        System.out.println(countDay());
    }

    private static int countDay(){
        Arrays.sort(dist);
        int limit = x / 2;
        if(dist[dist.length - 1] > limit){
            return -1;
        }

        int result = 0;
        int day = 1;
        for (int i = 0; i < n; i++) {
            result += dist[i];
            if(result > limit){
                result = dist[i];
                day++;
            }
        }
        return day;
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Node current = pq.poll();
            int toIdx = current.idx;
            if(dist[current.idx] < current.weight) {
                continue;
            }
            for (Node next : graph.get(toIdx)){
                if (dist[toIdx] + next.weight < dist[next.idx]){
                    dist[next.idx] = dist[toIdx] + next.weight;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }

        }

    }
    static class Node{
        int idx;
        int weight;

        Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }
}
