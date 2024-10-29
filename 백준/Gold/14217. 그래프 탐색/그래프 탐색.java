import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static int[][] dist;
    static int n, m;
    
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>(n + 1);

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        int q = Integer.parseInt(br.readLine());
        dist = new int[q + 1][n + 1];


        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            if(a == 1) {
                graph.get(to).add(from);
                graph.get(from).add(to);
            } else {
                graph.get(to).remove(Integer.valueOf(from));
                graph.get(from).remove(Integer.valueOf(to));
            }   

            Arrays.fill(dist[i], -1);
            
            bfs(i);
            for(int j = 1; j <= n; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int round) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new Node(1, 0));
        dist[round][1] = 0;
        visited[1] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curIdx = cur.idx;
            int curWeight = cur.weight;
            
            for(int next : graph.get(curIdx)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, curWeight + 1));
                    dist[round][next] = curWeight + 1;
                }
            }
        }
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