import java.io.*;
import java.util.*;

public class Solution {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());

                graph.get(to).add(from);
                graph.get(from).add(to);
            }
            visited = new boolean[n + 1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                if(!visited[i]){
                    bfs(i);
                }
            }

            sb.append("#").append(testCase).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for (int i : graph.get(node)) {
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        count++;
    }
}