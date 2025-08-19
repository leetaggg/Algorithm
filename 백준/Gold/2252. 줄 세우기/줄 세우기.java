import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            indegree[to]++;
        }

        topologicalSort(graph, indegree, n);

        System.out.println(sb);
    }

    static void topologicalSort(List<List<Integer>> graph, int[] indegree, int n) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node =  q.poll();

            sb.append(node + " ");

            for (int i : graph.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
    }
}
