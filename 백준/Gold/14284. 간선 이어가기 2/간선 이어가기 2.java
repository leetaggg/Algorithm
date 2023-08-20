import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n; i++){
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
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            int nowNode = pq.poll().idx;;
            for(Node nextNode : graph.get(nowNode)){
                if(dist[nowNode] + nextNode.weight < dist[nextNode.idx]){
                    dist[nextNode.idx] = dist[nowNode] + nextNode.weight;
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int idx;
    int weight;
    Node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}
