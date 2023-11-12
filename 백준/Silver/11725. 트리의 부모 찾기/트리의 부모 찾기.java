import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> tree;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>(n + 1);
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());

            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        dfs(1, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int visited){
        for (int node : tree.get(idx)) {
            if(node == visited) continue;
            parents[node] = idx;
            dfs(node, idx);
        }
    }
}
