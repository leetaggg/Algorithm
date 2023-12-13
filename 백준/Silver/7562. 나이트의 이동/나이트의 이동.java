import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int[] knight = new int[2];
            int[] goal = new int[2];

            knight[0] = Integer.parseInt(st.nextToken());
            knight[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            sb.append(bfs(knight, goal, n)).append("\n");
        }
        System.out.println(sb);

    }

    static int bfs(int[] knight, int[] goal, int n){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[] {knight[0], knight[1], 0});
        visited[knight[0]][knight[1]] = true;

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            if(r == goal[0] && c == goal[1]){
                return node[2];
            }
            for (int[] dir : dirs) {
                int dr = r + dir[0];
                int dc = c + dir[1];

                if(dr < 0 || n <= dr || dc < 0 || n <= dc || visited[dr][dc]) {
                    continue;
                }

                visited[dr][dc] = true;
                q.add(new int[] {dr, dc, node[2] + 1});
            }
        }
        return 0;
    }
}