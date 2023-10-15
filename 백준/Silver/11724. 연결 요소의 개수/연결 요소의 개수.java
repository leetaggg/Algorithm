import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

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

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int start){
        for (int next : graph.get(start)) {
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}