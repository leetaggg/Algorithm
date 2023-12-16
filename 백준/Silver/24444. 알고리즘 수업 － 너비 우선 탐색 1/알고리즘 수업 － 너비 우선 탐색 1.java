import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        for (int i = 1; i <= n; i++)
            Collections.sort(graph.get(i));

        bfs(R);

        for (int i = 1; i <= n; i++)
            System.out.println(visited[i]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(start);
        visited[start] = cnt++;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < graph.get(a).size(); i++) {
                int nextV = graph.get(a).get(i);

                if (visited[nextV] != 0)
                    continue;

                q.offer(nextV);
                visited[nextV] = cnt++;
            }
        }
    }
}